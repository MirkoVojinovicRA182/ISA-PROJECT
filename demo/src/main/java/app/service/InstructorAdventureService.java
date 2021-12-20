package app.service;

import app.domain.Instructor;
import app.domain.InstructorAdventure;
import app.dto.InstructorAdventureDTO;

import java.util.List;
import java.util.Set;

public interface InstructorAdventureService {

    public void saveAdventure(InstructorAdventureDTO instructorAdventure);
    public List<InstructorAdventureDTO> getAdventuresByInstructorId(Integer instructorId);
    public void deleteAdventure(Integer adventureId);
}
