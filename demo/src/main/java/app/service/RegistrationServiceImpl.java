package app.service;

import app.domain.*;
import app.domain.enums.UserType;
import app.dto.UserToRegisterDto;
import app.repository.*;
import app.utility.Utility;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Autowired
    private CottageOwnerRepository cottageOwnerRepository;

    @Autowired
    private ShipOwnerRepository shipOwnerRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public RegistrationRequest saveRegistrationRequest(RegistrationRequest request) { return registrationRequestRepository.save(request); }

    @Override
    public List<RegistrationRequest> findAll() { return registrationRequestRepository.findAll(); }

    @Override
    public ApplicationUser approveRegistration(UserToRegisterDto dto) throws Exception {
        Utility.sendMail(dto.getEmail(), "Approved", "Your registration request has been approved.");

        if(dto.getUserType().equals(UserType.CottageOwner))
            return cottageOwnerRepository.save(new CottageOwner(dto.getEmail(), dto.getPassword(),
                    dto.getName(), dto.getLastName(), dto.getAddress(), dto.getCity(),
                    dto.getCountry(), dto.getPhoneNumber()));
        if(dto.getUserType().equals(UserType.ShipOwner))
            return shipOwnerRepository.save(new ShipOwner(dto.getEmail(), dto.getPassword(), dto.getName(), dto.getLastName(),
                    dto.getAddress(), dto.getCity(), dto.getCountry(), dto.getPhoneNumber()));
        if(dto.getUserType().equals(UserType.Instructor))
            return instructorRepository.save(new Instructor(dto.getEmail(), dto.getPassword(), dto.getName(), dto.getLastName(),
                    dto.getAddress(), dto.getCity(), dto.getCountry(), dto.getPhoneNumber()));
        return null;
    }

    @Override
    public void ejectRegistration(String email) {
        Utility.sendMail(email, "Eject", "Your registration request has been denied.");
    }

    @Override
    public Administrator registerAdmin(UserToRegisterDto dto) {
        return administratorRepository.save(new Administrator(dto.getEmail(), dto.getPassword(),
                dto.getName(), dto.getLastName(), dto.getAddress(), dto.getCity(),
                dto.getCountry(), dto.getPhoneNumber()));
    }
}
