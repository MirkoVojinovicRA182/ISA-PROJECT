package app.service;

import app.domain.RegistrationRequest;

import java.util.Collection;

public interface RegistrationService {

    Collection<RegistrationRequest> findAll();
    RegistrationRequest createRegistrationRequest(RegistrationRequest request) throws Exception;
}
