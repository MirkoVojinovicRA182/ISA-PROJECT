package app.service;

import app.domain.Cottage;
import app.dto.CottageDTO;

public interface CottageService {
    void saveCottage(CottageDTO cottageDTO);
    void deleteCottage(Integer cottageId);
    CottageDTO updateCottage(CottageDTO cottageDTO);
    CottageDTO searchCottage(String searchFilter);
}
