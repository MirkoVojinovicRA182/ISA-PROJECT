package app.service;

import app.domain.Instructor;
import app.dto.InstructorAdventureDTO;
import app.dto.UserProfileDTO;

import java.util.List;

public interface EntityService {
    List<UserProfileDTO> getAllInstructors();

    List<InstructorAdventureDTO> getAllInstructorAdventures();
}
