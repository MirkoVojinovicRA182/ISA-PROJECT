package app.service;

import app.domain.ApplicationUser;
import app.domain.CottageOwner;
import app.domain.Instructor;
import app.domain.enums.UserType;
import app.dto.UserPasswordDTO;
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
    public UserProfileDTO updatePersonalInfo(UserProfileDTO dto) {
        if(dto.getUserType().equals(UserType.Instructor)){
            Instructor instructor = instructorRepository.findById(dto.getUserId()).orElseGet(null);
            instructor.updatePersonalInfo(dto);
            instructorRepository.save(instructor);
        }

        return dto;
    }

    @Override
    public UserProfileDTO updatePassword(UserPasswordDTO userPasswordDTO) {
        UserProfileDTO dto = new UserProfileDTO();
        if(userPasswordDTO.getUserType().equals(UserType.Instructor)){
            Instructor instructor = instructorRepository.findById(userPasswordDTO.getUserId()).orElseGet(null);
            instructor.setPassword(userPasswordDTO.getNewPassword());
            instructorRepository.save(instructor);
            dto = new UserProfileDTO((ApplicationUser)instructor);
        }

        return dto;
    }
}
