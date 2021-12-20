package app.service;

import app.domain.Instructor;
import app.dto.InstructorAdventureDTO;

import java.util.Optional;

public interface InstructorAdventureService {

    void saveAdventure(InstructorAdventureDTO instructorAdventure);

}
