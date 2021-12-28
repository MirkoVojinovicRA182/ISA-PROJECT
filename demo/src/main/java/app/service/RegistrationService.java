package app.service;

import app.domain.Administrator;
import app.domain.Client;
import app.domain.RegistrationRequest;
import app.domain.ApplicationUser;
import app.domain.enums.UserType;
import app.dto.ClientDTO;
import app.dto.UserToRegisterDto;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

public interface RegistrationService {

    List<RegistrationRequest> findAll();
    ApplicationUser approveRegistration(UserToRegisterDto dto) throws Exception;
    void registerClient(ClientDTO dto, String siteURL) throws UnsupportedEncodingException, MessagingException;
    RegistrationRequest saveRegistrationRequest(RegistrationRequest request);
    void ejectRegistration(String email);
    Administrator registerAdmin(UserToRegisterDto dto);
    boolean verify(String code);
}
