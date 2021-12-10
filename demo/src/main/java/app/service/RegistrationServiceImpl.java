package app.service;

import app.domain.RegistrationRequest;
import app.domain.User;
import app.repository.RegistrationRepository;
import app.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public Collection<RegistrationRequest> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public RegistrationRequest createRegistrationRequest(RegistrationRequest request) throws Exception {
        if (request.getId() != null) {
            throw new Exception("Id needs to be null.");
        }
        if(request.getUserToRegister() == null){
            throw new Exception("User can't be null!");
        }
        return registrationRepository.createRegistrationRequest(request);
    }

    @Override
    public User approveRegistration(User newUser) throws Exception {
        if (newUser.getId() != null) {
            throw new Exception("Id needs to be null.");
        }
        Utility.sendMail(newUser.getEmail(), "Approved", "Your registration request has been approved.");

        return registrationRepository.registerUser(newUser);
    }

    @Override
    public void ejectRegistration(String email) {
        Utility.sendMail(email, "Eject", "Your registration request has been denied.");
    }
}
