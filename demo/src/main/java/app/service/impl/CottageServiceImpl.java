package app.service.impl;

import app.domain.Cottage;
import app.domain.CottageImage;
import app.domain.Mark;
import app.domain.Room;
import app.dto.CottageDTO;
import app.repository.CottageImageRepository;
import app.repository.CottageOwnerRepository;
import app.repository.CottageRepository;
import app.repository.CottageRoomRepository;
import app.service.CottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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

    @Override
    public void saveCottage(CottageDTO cottageDTO) {
        Cottage newCottage = new Cottage(
                cottageDTO.getName(),
                cottageDTO.getAddress(),
                cottageDTO.getPromotiveDescription(),
                cottageDTO.getConductRules(),
                cottageDTO.getPricelist(),
                cottageOwnerRepository.findById(cottageDTO.getCottageOwnerId()).orElseGet(null));
        cottageRepository.save(newCottage);
    }

    @Override
    public void deleteCottage(Integer cottageId) {
        cottageRepository.deleteById(cottageId);
    }

    @Override
    public CottageDTO updateCottage(CottageDTO cottageDTO) {
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
    public CottageDTO addImage(Integer cottageId, Set<String> imgsUrl) {
        Cottage cottageForUpdate = cottageRepository.findById(cottageId).orElseGet(null);
        Set<CottageImage> images = new HashSet<>();
        for(String imgUrl : imgsUrl){
            CottageImage image = new CottageImage(imgUrl, cottageForUpdate);
            images.add(image);
        }
        cottageImageRepository.saveAll(images);
        cottageForUpdate.getImages().addAll(images);
        cottageRepository.save(cottageForUpdate);
        return new CottageDTO(cottageForUpdate);
    }

    @Override
    public CottageDTO addRoom(Integer cottageId, Set<Room> rooms) {
        Cottage cottageForUpdate = cottageRepository.findById(cottageId).orElseGet(null);
        Set<Room> newRooms = new HashSet<>();
        cottageRoomRepository.saveAll(newRooms);
        cottageForUpdate.getRooms().addAll(newRooms);
        cottageRepository.save(cottageForUpdate);
        return new CottageDTO(cottageForUpdate);
    }

    @Override
    public Integer rateCottage(Integer cottageId, Mark mark) {
        Cottage cottageForUpdate = cottageRepository.findById(cottageId).orElseGet(null);
        cottageForUpdate.rateCottage(mark);
        cottageRepository.save(cottageForUpdate);
        return cottageForUpdate.getRating();
    }


}
