package app.service;

import app.domain.Instructor;
import app.dto.*;

import java.util.List;

public interface EntityService {
    List<UserProfileDTO> getAllInstructors();

    List<InstructorAdventureDTO> getAllInstructorAdventures();

    UserRequest getInstructorById(Integer id);

    UserRequest getAdministratorById(Integer id);

    List<CottageDTO> getAllCottages();

    void deleteCottage(Integer cottageId);

    List<ShipDTO> getAllShips();

    void deleteShip(Integer shipId);

    UserRequest getCottageOwnerById(Integer id);

    UserRequest getShipOwnerById(Integer id);
}
