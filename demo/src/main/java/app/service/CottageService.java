package app.service;

import app.domain.Mark;
import app.domain.Room;
import app.dto.CottageDTO;

import java.util.Set;

public interface CottageService {
    void saveCottage(CottageDTO cottageDTO);
    void deleteCottage(Integer cottageId);
    CottageDTO updateCottage(CottageDTO cottageDTO);
    Set<CottageDTO> searchCottage(Integer cottageOwnerId, String searchFilter);
    Set<CottageDTO> getCottageOwnerCottager(Integer cottageOwnerId);
    CottageDTO getCottageById(Integer cottageId);
    CottageDTO addImage(Integer cottageId, Set<String> imgUrl);
    CottageDTO addRoom(Integer cottageId, Set<Room> imgUrl);
    Integer rateCottage(Integer cottageId, Mark mark);
}
