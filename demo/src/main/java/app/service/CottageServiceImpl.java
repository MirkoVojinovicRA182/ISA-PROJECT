package app.service;

import app.domain.Cottage;
import app.dto.CottageDTO;
import app.repository.CottageOwnerRepository;
import app.repository.CottageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CottageServiceImpl implements CottageService{

    @Autowired
    private CottageOwnerRepository cottageOwnerRepository;

    @Autowired
    private CottageRepository cottageRepository;

    @Override
    public void saveCottage(CottageDTO cottageDTO) {
        Cottage newCottage = new Cottage(
                cottageDTO.getName(),
                cottageDTO.getAddress(),
                cottageDTO.getPromotiveDescription(),
                cottageDTO.getRoomsNumber(),
                cottageDTO.getBedsNumber(),
                cottageDTO.getConductRules(),
                cottageDTO.getPricelist(),
                cottageOwnerRepository.getById(cottageDTO.getCottageOwnerId()));
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
    public Set<CottageDTO> searchCottage(String searchFilter) {
        Set<CottageDTO> cottageDTOS = new HashSet<>();
        if(cottageRepository.searchCottage(searchFilter) != null)
            for(Cottage cottage: cottageRepository.searchCottage(searchFilter)){
                cottageDTOS.add(new CottageDTO(cottage));
            }
        return cottageDTOS;
    }

    @Override
    public Set<CottageDTO> getCottageOwnerCottager(Integer cottageOwnerId) {
        Set<CottageDTO> cottageDTOS = new HashSet<>();
        if(cottageRepository.getCottageOwnerCottages(cottageOwnerId) != null)
            for(Cottage cottage: cottageRepository.getCottageOwnerCottages(cottageOwnerId)){
                cottageDTOS.add(new CottageDTO(cottage));
            }
        return cottageDTOS;
    }
}
