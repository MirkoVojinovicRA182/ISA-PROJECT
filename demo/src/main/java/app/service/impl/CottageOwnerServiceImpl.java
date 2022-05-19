package app.service.impl;

import app.domain.CottageOwner;
import app.dto.CottageOwnerDTO;
import app.repository.CottageOwnerRepository;
import app.service.CottageOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CottageOwnerServiceImpl implements CottageOwnerService {

    @Autowired
    private CottageOwnerRepository cottageOwnerRepository;

    @Override
    public void saveCottageOwner(CottageOwnerDTO cottageOwnerDTO) {
        CottageOwner newCottageOwner = new CottageOwner(cottageOwnerDTO.getEmail(), cottageOwnerDTO.getPassword(),
                cottageOwnerDTO.getName(), cottageOwnerDTO.getLastName(), cottageOwnerDTO.getAddress(), cottageOwnerDTO.getCity(),
                cottageOwnerDTO.getCountry(), cottageOwnerDTO.getPhoneNumber());
        cottageOwnerRepository.save(newCottageOwner);
    }

    @Override
    public void deleteCottageOwner(Integer cottageOwnerId) {
        cottageOwnerRepository.deleteById(cottageOwnerId);
    }

    @Override
    public CottageOwnerDTO updateCottageOwner(CottageOwnerDTO cottageOwnerDTO) {
        CottageOwner cottageOwnerForUpdate = cottageOwnerRepository.findById(cottageOwnerDTO.getCottageOwnerId()).orElseGet(null);
        cottageOwnerForUpdate.update(cottageOwnerDTO);
        cottageOwnerRepository.save(cottageOwnerForUpdate);
        return new CottageOwnerDTO(cottageOwnerForUpdate);
    }
}
