package app.service;

import app.domain.Instructor;
import app.domain.InstructorAdventure;
import app.dto.InstructorAdventureDTO;
import app.repository.InstructorAdventureRepository;
import app.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorAdventureServiceImpl implements InstructorAdventureService{

    @Autowired
    private InstructorAdventureRepository instructorAdventureRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public void saveAdventure(InstructorAdventureDTO dto) {
        InstructorAdventure adventure = new InstructorAdventure(
                dto.getName(),
                dto.getAddress(),
                dto.getPromotionalDescription(),
                dto.getInstructorBiography(),
                dto.getMaxCountOfParticipants(),
                dto.getRulesOfConduct(),
                dto.getDefaultEquipment(),
                dto.getPricelist(),
                dto.getTermsOfUse(),
                instructorRepository.getById(dto.getInstructorId()));
        instructorAdventureRepository.save(adventure);
    }

    @Override
    public List<InstructorAdventureDTO> getAdventuresByInstructorId(Integer instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElseGet(null);
        List<InstructorAdventureDTO> adventures = new ArrayList<InstructorAdventureDTO>();
        for(InstructorAdventure a: instructor.getAdventures())
            adventures.add(new InstructorAdventureDTO(a));
        return adventures;
    }
}
