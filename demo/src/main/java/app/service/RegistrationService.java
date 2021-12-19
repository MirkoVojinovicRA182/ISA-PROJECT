package app.service;

import app.domain.RegistrationRequest;
import app.domain.ApplicationUser;
import app.domain.enums.UserType;
import app.dto.UserToRegisterDto;

import java.util.Collection;
import java.util.List;

public interface RegistrationService {

    List<RegistrationRequest> findAll();
    ApplicationUser approveRegistration(UserToRegisterDto dto) throws Exception;
    public RegistrationRequest saveRegistrationRequest(RegistrationRequest request);
    void ejectRegistration(String email);
}
