package app.service;

import app.domain.CottageOwner;
import app.domain.Instructor;
import app.domain.enums.UserType;
import app.dto.UserProfileDTO;
import app.repository.CottageOwnerRepository;
import app.repository.InstructorRepository;
import app.repository.ShipOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CottageOwnerRepository cottageOwnerRepository;

    @Autowired
    private ShipOwnerRepository shipOwnerRepository;

    @Override
    public UserProfileDTO updateUserProfile(UserProfileDTO dto) {
        if(dto.getUserType().equals(UserType.Instructor)){
            Instructor instructor = instructorRepository.findById(dto.getUserId()).orElseGet(null);
            instructor.updatePersonalInfo(dto);
            instructorRepository.save(instructor);
        }

        return dto;
    }
}
