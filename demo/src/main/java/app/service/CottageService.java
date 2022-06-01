package app.service;

import app.domain.Mark;
import app.domain.Room;
import app.dto.*;

import java.io.IOException;
import java.util.Set;

public interface CottageService {
    CottageDTO saveCottage(ChangeCottageDTO cottageDTO);
    void deleteCottage(Integer cottageId);
    CottageDTO updateCottage(ChangeCottageDTO cottageDTO);
    Set<CottageDTO> searchCottage(Integer cottageOwnerId, String searchFilter);
    Set<CottageDTO> getCottageOwnerCottager(String cottageOwnerUsername);
    CottageDTO getCottageById(Integer cottageId);
    CottageDTO addImage(Set<CottageImageDTO> imgUrl) throws IOException;
    CottageDTO addRoom(Set<RoomDTO> imgUrl);
    Integer rateCottage(Integer cottageId, MarkDTO mark);
    CottageDTO addCottageAvailability(Integer cottageId, Set<CottageAvailabilityDTO> availability);

    CottageDTO removeImage(CottageImageDTO img);
}
