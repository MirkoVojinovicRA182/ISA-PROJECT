package app.service.impl;

import app.domain.*;
import app.dto.*;
import app.repository.*;
import app.service.CottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class CottageServiceImpl implements CottageService {

    @Autowired
    private CottageOwnerRepository cottageOwnerRepository;

    @Autowired
    private CottageRepository cottageRepository;

    @Autowired
    private CottageImageRepository cottageImageRepository;

    @Autowired
    private CottageRoomRepository cottageRoomRepository;

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private CottageAvailabilityRepository cottageAvailabilityRepository;

    @Override
    public CottageDTO saveCottage(ChangeCottageDTO cottageDTO) {
        Cottage newCottage = new Cottage(
                cottageDTO.getName(),
                cottageDTO.getAddress(),
                cottageDTO.getPromotiveDescription(),
                cottageDTO.getConductRules(),
                cottageDTO.getPricelist(),
                cottageOwnerRepository.findById(cottageDTO.getCottageOwnerId()).orElseGet(null));
        cottageRepository.save(newCottage);
        return new CottageDTO(newCottage);
    }

    @Override
    public void deleteCottage(Integer cottageId) {
        cottageRepository.deleteById(cottageId);
    }

    @Override
    public CottageDTO updateCottage(ChangeCottageDTO cottageDTO) {
        Cottage cottageForUpdate = cottageRepository.findById(cottageDTO.getCottageId()).orElseGet(null);
        cottageForUpdate.update(cottageDTO);
        cottageRepository.save(cottageForUpdate);
        return new CottageDTO(cottageForUpdate);
    }

    @Override
    public Set<CottageDTO> searchCottage(Integer cottageOwnerId, String searchFilter) {
        Set<CottageDTO> cottageDTOS = new HashSet<>();
        if(cottageRepository.searchCottage(cottageOwnerId, searchFilter) != null)
            for(Cottage cottage: cottageRepository.searchCottage(cottageOwnerId, searchFilter)){
                cottageDTOS.add(new CottageDTO(cottage));
            }
        return cottageDTOS;
    }

    @Override
    public Set<CottageDTO> getCottageOwnerCottager(String cottageOwnerUsername) {
        Set<CottageDTO> cottageDTOS = new HashSet<>();
        if(cottageRepository.getCottageOwnerCottages(cottageOwnerUsername) != null)
            for(Cottage cottage: cottageRepository.getCottageOwnerCottages(cottageOwnerUsername)){
                cottageDTOS.add(new CottageDTO(cottage));
            }
        return cottageDTOS;
    }

    @Override
    public CottageDTO getCottageById(Integer cottageId) {
        return new CottageDTO(cottageRepository.getByCottageId(cottageId));
    }

    @Override
    public CottageDTO addImage(Set<CottageImageDTO> imgs) throws IOException {
        CottageImageDTO firstImage = imgs.stream().findFirst().orElseGet(null);
        Cottage cottageForUpdate = cottageRepository.findById(firstImage.getCottageId()).orElseGet(null);
        Set<CottageImage> images = new HashSet<>();
        for(CottageImageDTO img : imgs){
            CottageImage image = new CottageImage("../angular-frontend/src/assets/cottage/" + img.getUrl() + "-" + cottageForUpdate.getImages().size() + ".png", cottageForUpdate);
            images.add(image);
            String base64Image = img.getBase64().split(",")[1];
            byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
            File outputfile = new File(image.getUrl());
            try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputfile))) {
                outputStream.write(imageBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            cottageForUpdate.getImages().add(image);
        }
        cottageImageRepository.saveAll(images);
        cottageRepository.save(cottageForUpdate);
        return new CottageDTO(cottageForUpdate);
    }

    @Override
    public CottageDTO removeImage(CottageImageDTO img) {
        Cottage cottageForUpdate = cottageRepository.findById(img.getCottageId()).orElseGet(null);
        Set<CottageImage> images = cottageImageRepository.getByCottage(cottageForUpdate.getId());
        CottageImage image = cottageImageRepository.findById(img.getCottageImageid()).orElseGet(null);
        File outputfile = new File(image.getUrl());
        outputfile.delete();
        cottageForUpdate.getImages().removeIf(i -> i.getId().equals(image.getId()));
        images.removeIf(i -> i.getId().equals(image.getId()));
        cottageRepository.save(cottageForUpdate);
        cottageImageRepository.deleteById(image.getId());
        return new CottageDTO(cottageForUpdate);
    }

    @Override
    public void deleteCottageAvailability(Integer availabilityId) {
        cottageAvailabilityRepository.deleteById(availabilityId);
    }

    @Override
    public CottageDTO addRoom(Set<RoomDTO> rooms) {
        RoomDTO roomD = rooms.stream().findFirst().orElseGet(null);
        Cottage cottageForUpdate = cottageRepository.findById(roomD.getCottageId()).orElseGet(null);
        Set<Room> newRooms = new HashSet<>();
        for(RoomDTO roomDTO : rooms){
            Room room = new Room(roomDTO.getRoomId(), roomDTO.getRoomNumber(), roomDTO.getBedsNumber(), roomDTO.isBathroom(), roomDTO.isClime(),
                    cottageRepository.findById(roomDTO.getCottageId()).orElseGet(null));
            newRooms.add(room);
        }
        cottageRoomRepository.saveAll(newRooms);
        cottageForUpdate.getRooms().addAll(newRooms);
        cottageRepository.save(cottageForUpdate);
        return new CottageDTO(cottageForUpdate);
    }

    @Override
    public Integer rateCottage(MarkDTO mark) {
        /*Cottage cottageForUpdate = cottageRepository.findById(mark.getCottageId()).orElseGet(null);
        Mark newMark = new Mark(mark);
        newMark.setCottage(cottageForUpdate);
        cottageForUpdate.rateCottage(newMark);
        markRepository.save(newMark);
        cottageRepository.save(cottageForUpdate);
        return cottageForUpdate.getRating();*/
        return 0;
    }

    @Override
    public CottageDTO addCottageAvailability(Set<CottageAvailabilityDTO> availability) {
        CottageAvailabilityDTO newDto = availability.stream().findFirst().orElseGet(null);
        Cottage cottageForUpdate = cottageRepository.findById(newDto.getCottageId()).orElseGet(null);
        for(CottageAvailabilityDTO cottageAvailabilityDTO : availability){
            if(cottageAvailabilityDTO.getEndDate().isBefore(LocalDateTime.now())){
                return new CottageDTO(cottageForUpdate);
            }
            if(cottageAvailabilityDTO.getStartDate().isBefore(cottageAvailabilityDTO.getEndDate()) || cottageAvailabilityDTO.getStartDate().isEqual(cottageAvailabilityDTO.getEndDate())) {
                CottageAvailability cottageAvailability = new CottageAvailability(cottageAvailabilityDTO);
                cottageAvailability.setCottage(cottageForUpdate);
                boolean overlap = false;
                for (CottageAvailability c : cottageForUpdate.getCottageAvailability()) {
                    if (cottageAvailability.getStartDate().isBefore(c.getStartDate()) && cottageAvailability.getEndDate().isBefore(c.getStartDate()) ||
                            cottageAvailability.getStartDate().isAfter(c.getEndDate()) && cottageAvailability.getEndDate().isAfter(c.getEndDate())) {
                        overlap = overlap;
                    } else {
                        overlap = true;
                    }
                }
                if ((cottageAvailability.getEndDate().isAfter(cottageAvailability.getStartDate()) || cottageAvailability.getEndDate().isEqual(cottageAvailability.getStartDate())) && !overlap) {
                    cottageAvailabilityRepository.save(cottageAvailability);
                    cottageForUpdate.getCottageAvailability().add(cottageAvailability);
                    cottageRepository.save(cottageForUpdate);
                }
            }
        }
        cottageRepository.save(cottageForUpdate);
        return new CottageDTO(cottageForUpdate);
    }

    public boolean isCottageAvailable(Integer cottageId, LocalDateTime startDate, LocalDateTime endDate){
        if(startDate.isAfter(endDate))
            return false;
        Cottage cottage = cottageRepository.findById(cottageId).orElseGet(null);
        for(CottageAvailability c : cottage.getCottageAvailability()){
            if ((startDate.isAfter(c.getStartDate()) || startDate.isEqual(c.getStartDate())) && (startDate.isBefore(c.getEndDate()) || startDate.isEqual(c.getEndDate())) &&
                (endDate.isAfter(c.getStartDate()) || endDate.isEqual(c.getStartDate())) && (endDate.isBefore(c.getEndDate()) || endDate.isEqual(c.getEndDate()))){
                for(CottageReservation r : cottage.getCottageReservations()){
                    if((r.getStartTime().isAfter(ChronoLocalDateTime.from(startDate)) || r.getEndTime().isBefore(ChronoLocalDateTime.from(endDate))) ||
                        r.getStartTime().isBefore(ChronoLocalDateTime.from(startDate)) && r.getEndTime().isAfter(ChronoLocalDateTime.from(endDate))){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
