package app.service;

import app.domain.Instructor;
import app.domain.InstructorAdventure;
import app.dto.InstructorAdventureDTO;
import app.dto.UserProfileDTO;
import app.repository.InstructorAdventureRepository;
import app.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityServiceImpl implements EntityService{

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorAdventureRepository instructorAdventureRepository;

    @Override
    public List<UserProfileDTO> getAllInstructors() {
        List<UserProfileDTO> userProfileDTOS = new ArrayList<UserProfileDTO>();
        for(Instructor instructor: instructorRepository.findAll())
            userProfileDTOS.add(new UserProfileDTO(instructor));
        return userProfileDTOS;
    }

    @Override
    public List<InstructorAdventureDTO> getAllInstructorAdventures() {
        List<InstructorAdventureDTO> adventureDTOS = new ArrayList<InstructorAdventureDTO>();
        for(InstructorAdventure adventure: instructorAdventureRepository.findAll())
            adventureDTOS.add(new InstructorAdventureDTO(adventure));
        return adventureDTOS;
    }
}
