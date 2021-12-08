package app.service;

import app.domain.RegistrationRequest;
import app.repository.RegistrationRepository;
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
}
