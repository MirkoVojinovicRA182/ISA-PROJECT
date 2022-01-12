package app.service;

import app.dto.CottageOwnerDTO;

public interface CottageOwnerService {
    void saveCottageOwner(CottageOwnerDTO cottageOwnerDTO);
    void deleteCottageOwner(Integer cottageOwnerId);
    CottageOwnerDTO updateCottageOwner(CottageOwnerDTO cottageOwnerDTO);
}
