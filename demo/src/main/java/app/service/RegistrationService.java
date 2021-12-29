package app.service;

import app.domain.Administrator;
import app.domain.RegistrationRequest;
import app.domain.ApplicationUser;
import app.dto.ClientDTO;
import app.dto.UserToRegisterDto;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface RegistrationService {

    List<RegistrationRequest> findAll();
    ApplicationUser approveRegistration(RegistrationRequest registrationRequest) throws Exception;
    void registerClient(ClientDTO dto, String siteURL) throws UnsupportedEncodingException, MessagingException;
    RegistrationRequest saveRegistrationRequest(RegistrationRequest request);
    void ejectRegistration(RegistrationRequest email);
    Administrator registerAdmin(UserToRegisterDto dto);
    boolean verify(String code);
}
