package app.service;

import app.domain.Instructor;
import app.domain.InstructorAdventure;
import app.dto.AdventureAdditionalServiceDTO;
import app.dto.InstructorAdventureDTO;

import java.util.List;
import java.util.Set;

public interface InstructorAdventureService {

    void saveAdventure(InstructorAdventureDTO instructorAdventure);
    List<InstructorAdventureDTO> getAdventuresByInstructorId(Integer instructorId);
    void deleteAdventure(Integer adventureId);

    InstructorAdventureDTO updateAdventure(InstructorAdventureDTO dto);

    InstructorAdventureDTO getAdventureById(Integer id);

    List<AdventureAdditionalServiceDTO> getAdditionalServices(Integer aventureId);

    void saveAdditionalService(AdventureAdditionalServiceDTO dto);

    void deleteAdditionalService(Integer id);
}
