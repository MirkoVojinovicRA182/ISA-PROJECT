package app.service;

import app.domain.Administrator;
import app.domain.Cottage;
import app.domain.Instructor;
import app.domain.InstructorAdventure;
import app.dto.CottageDTO;
import app.dto.InstructorAdventureDTO;
import app.dto.UserProfileDTO;
import app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityServiceImpl implements EntityService{

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private InstructorAdventureRepository instructorAdventureRepository;

    @Autowired
    private CottageRepository cottageRepository;

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

    @Override
    public UserProfileDTO getInstructorById(Integer id) {
        Instructor instructor = instructorRepository.findById(id).orElseGet(null);
        if(instructor != null)
            return new UserProfileDTO(instructor);
        return null;
    }

    @Override
    public UserProfileDTO getAdministratorById(Integer id) {
        Administrator administrator = administratorRepository.findById(id).orElseGet(null);
        if(administrator != null)
            return new UserProfileDTO(administrator);
        return null;
    }

    @Override
    public List<CottageDTO> getAllCottages() {
        List<CottageDTO> cottageDTOS = new ArrayList<CottageDTO>();
        for (Cottage cottage: cottageRepository.findAll())
            cottageDTOS.add(new CottageDTO(cottage));

        return cottageDTOS;
    }

    @Override
    public void deleteCottage(Integer cottageId) {
        this.cottageRepository.deleteById(cottageId);
    }
}
