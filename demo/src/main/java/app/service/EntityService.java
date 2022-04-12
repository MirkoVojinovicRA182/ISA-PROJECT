package app.service;

import app.domain.Instructor;
import app.dto.CottageDTO;
import app.dto.InstructorAdventureDTO;
import app.dto.ShipDTO;
import app.dto.UserProfileDTO;

import java.util.List;

public interface EntityService {
    List<UserProfileDTO> getAllInstructors();

    List<InstructorAdventureDTO> getAllInstructorAdventures();

    UserProfileDTO getInstructorById(Integer id);

    UserProfileDTO getAdministratorById(Integer id);

    List<CottageDTO> getAllCottages();

    void deleteCottage(Integer cottageId);

    List<ShipDTO> getAllShips();

    void deleteShip(Integer shipId);
}
