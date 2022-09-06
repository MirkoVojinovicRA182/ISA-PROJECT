package app.service.impl;

import app.domain.Cottage;
import app.domain.CottageImage;
import app.domain.Ship;
import app.domain.ShipImage;
import app.domain.ShipOwner;
import app.dto.CottageDTO;
import app.dto.CottageImageDTO;
import app.dto.ShipDTO;
import app.dto.ShipWithImagesDTO;
import app.repository.ShipImageRepository;
import app.repository.ShipOwnerRepository;
import app.repository.ShipRepository;
import app.service.ShipService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
}
