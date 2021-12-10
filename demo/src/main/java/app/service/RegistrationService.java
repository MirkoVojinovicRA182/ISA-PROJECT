package app.service;

import app.domain.RegistrationRequest;
import app.domain.User;

import java.util.Collection;

public interface RegistrationService {

    Collection<RegistrationRequest> findAll();
    RegistrationRequest createRegistrationRequest(RegistrationRequest request) throws Exception;
    User approveRegistration(User registrationRequest) throws Exception;

    void ejectRegistration(String email);
}
