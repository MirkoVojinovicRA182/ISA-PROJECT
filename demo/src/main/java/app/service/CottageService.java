package app.service;

import app.dto.CottageDTO;

import java.util.Set;

public interface CottageService {
    void saveCottage(CottageDTO cottageDTO);
    void deleteCottage(Integer cottageId);
    CottageDTO updateCottage(CottageDTO cottageDTO);
    Set<CottageDTO> searchCottage(Integer cottageOwnerId, String searchFilter);
    Set<CottageDTO> getCottageOwnerCottager(Integer cottageOwnerId);
    CottageDTO getCottageById(Integer cottageId);
}
