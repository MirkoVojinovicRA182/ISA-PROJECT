package app.service.impl;

import app.domain.*;
import app.dto.*;
import app.repository.*;
import app.service.ShipService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    private ShipOwnerRepository shipOwnerRepository;

    @Autowired
    private ShipRepository shipRepository;
    
    @Autowired
    private ShipImageRepository shipImageRepository;
    @Autowired
    private ShipAvailabilityRepository shipAvailabilityRepository;
    @Autowired
    private ShipReservationRepository shipReservationRepository;
    @Autowired
    private ShipReservationReportRepository shipReservationReportRepository;

    @Override
    public void saveShip(ShipDTO shipDTO) {
        Ship newShip = new Ship(shipDTO.getName(), shipDTO.getType(), shipDTO.getLength(), shipDTO.getEngineNumber(), shipDTO.getEnginePower(),
                shipDTO.getMaxSpeed(), shipDTO.getAddress(), shipDTO.getPromotiveDescription(), shipDTO.getCapacity(), shipDTO.getConductRules(),
                shipDTO.getPricelist(), shipDTO.getAdditionalServicesInfo(), shipDTO.getCancellationPolicy(), shipOwnerRepository.getById(shipDTO.getShipOwnerId()));
        newShip.setRating(5.0);
        shipRepository.save(newShip);
    }

    @Override
    public void deleteShip(Integer shipId) {
        shipRepository.deleteById(shipId);
    }

    @Override
    public ShipWithImagesDTO updateShip(ShipDTO shipDTO) {
        Ship shipForUpdate = shipRepository.findById(shipDTO.getShipId()).orElseGet(null);
        shipForUpdate.update(shipDTO);
        shipRepository.save(shipForUpdate);
        return new ShipWithImagesDTO(shipForUpdate);
    }

    @Override
    public ShipDTO getShipById(Integer shipId) {
        Ship ship = shipRepository.findById(shipId).orElseGet(null);
        if (ship == null) {
            return null;
        }
        return new ShipDTO(ship);
    }
    
    @Override
    public List<ShipWithImagesDTO> getUserShips(Integer userId){
    	List<Ship> ships = shipRepository.getUserShips(userId);
    	List<ShipWithImagesDTO> dtos = new ArrayList<>();
    	for(Ship ship : ships) {
            ShipWithImagesDTO dto = new ShipWithImagesDTO(ship);
    		dtos.add(dto);
    	}
    	return dtos;
    }
    
    @Override
    public ShipWithImagesDTO addImage(Set<CottageImageDTO> imgs) {
        CottageImageDTO firstImage = imgs.stream().findFirst().orElseGet(null);
        Ship shipForUpdate = shipRepository.findById(firstImage.getCottageId()).orElseGet(null);
        Set<ShipImage> images = new HashSet<>();
        for(CottageImageDTO img : imgs){
            ShipImage image = new ShipImage("../angular-frontend/src/assets/ship/" + img.getUrl() + "-" + shipForUpdate.getImages().size() + ".png", shipForUpdate);
            images.add(image);
            String base64Image = img.getBase64().split(",")[1];
            byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
            File outputfile = new File(image.getUrl());
            try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputfile))) {
                outputStream.write(imageBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            shipForUpdate.getImages().add(image);
        }
        shipImageRepository.saveAll(images);
        shipRepository.save(shipForUpdate);
        return new ShipWithImagesDTO(shipForUpdate);
    }

    @Override
    public ShipWithImagesDTO removeImage(CottageImageDTO img) {
        Ship shipForUpdate = shipRepository.findById(img.getCottageId()).orElseGet(null);
        Set<ShipImage> images = shipImageRepository.getByShip(shipForUpdate.getId());
        ShipImage image = shipImageRepository.findById(img.getCottageImageid()).orElseGet(null);
        File outputfile = new File(image.getUrl());
        outputfile.delete();
        shipForUpdate.getImages().removeIf(i -> i.getId().equals(image.getId()));
        images.removeIf(i -> i.getId().equals(image.getId()));
        shipRepository.save(shipForUpdate);
        shipImageRepository.deleteById(image.getId());
        return new ShipWithImagesDTO(shipForUpdate);
    }

    @Override
    public ShipWithImagesDTO addShipAvailability(Set<ShipAvailabilityDTO> availability) {
        ShipAvailabilityDTO newDto = availability.stream().findFirst().orElseGet(null);
        Ship shipForUpdate = shipRepository.findById(newDto.getShipId()).orElseGet(null);
        for(ShipAvailabilityDTO shipAvailabilityDTO : availability){
            if(shipAvailabilityDTO.getEndDate().isBefore(LocalDateTime.now())){
                return new ShipWithImagesDTO(shipForUpdate);
            }
            if(shipAvailabilityDTO.getStartDate().isBefore(shipAvailabilityDTO.getEndDate()) || shipAvailabilityDTO.getStartDate().isEqual(shipAvailabilityDTO.getEndDate())) {
                ShipAvailability shipAvailability = new ShipAvailability(shipAvailabilityDTO);
                shipAvailability.setShip(shipForUpdate);
                boolean overlap = false;
                for (ShipAvailability c : shipForUpdate.getShipAvailability()) {
                    if (shipAvailability.getStartDate().isBefore(c.getStartDate()) && shipAvailability.getEndDate().isBefore(c.getStartDate()) ||
                            shipAvailability.getStartDate().isAfter(c.getEndDate()) && shipAvailability.getEndDate().isAfter(c.getEndDate())) {
                        overlap = overlap;
                    } else {
                        overlap = true;
                    }
                }
                if ((shipAvailability.getEndDate().isAfter(shipAvailability.getStartDate()) || shipAvailability.getEndDate().isEqual(shipAvailability.getStartDate())) && !overlap) {
                    shipAvailabilityRepository.save(shipAvailability);
                    shipForUpdate.getShipAvailability().add(shipAvailability);
                    shipRepository.save(shipForUpdate);
                }
            }
        }
        shipRepository.save(shipForUpdate);
        return new ShipWithImagesDTO(shipForUpdate);
    }

    public ShipReservationReportDTO createReport(ShipReservationReportDTO dto){
        ShipReservation reservation = shipReservationRepository.findById(dto.getReservationId()).orElse(null);
        if (reservation == null){
            return null;
        }
        ShipReservationReport report = shipReservationReportRepository.save(new ShipReservationReport(dto.getReportText(), reservation));
        return new ShipReservationReportDTO(report.getReportText(), report.getReservation().getId());
    }
}
