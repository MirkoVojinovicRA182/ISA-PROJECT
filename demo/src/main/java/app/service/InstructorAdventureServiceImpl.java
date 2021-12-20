package app.service;

import app.domain.Instructor;
import app.domain.InstructorAdventure;
import app.dto.InstructorAdventureDTO;
import app.repository.InstructorAdventureRepository;
import app.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorAdventureServiceImpl implements InstructorAdventureService{

    @Autowired
    private InstructorAdventureRepository instructorAdventureRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public void saveAdventure(InstructorAdventureDTO dto) {
        Instructor instructor = instructorRepository.getById(dto.getInstructorId());

        InstructorAdventure adventure = new InstructorAdventure();
        adventure.setName(dto.getName());
        adventure.setAddress(dto.getAddress());
        adventure.setPromotionalDescription(dto.getPromotionalDescription());
        adventure.setInstructorBiography(dto.getInstructorBiography());
        adventure.setMaxCountOfParticipants(dto.getMaxCountOfParticipants());
        adventure.setRulesOfConduct(dto.getRulesOfConduct());
        adventure.setDefaultEquipment(dto.getDefaultEquipment());
        adventure.setPricelist(dto.getPricelist());
        adventure.setTermsOfUse(dto.getTermsOfUse());
        adventure.setInstructor(instructor);

        //instructor.addAdventure(adventure);

        instructorAdventureRepository.save(adventure);
    }
}
