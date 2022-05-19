package app.service.impl;

import app.domain.*;
import app.domain.enums.UserType;
import app.dto.ClientDTO;
import app.dto.EjectRegistrationRequestDTO;
import app.dto.UserRequest;
import app.dto.UserToRegisterDto;
import app.repository.*;
import app.service.RegistrationService;
import app.service.RoleService;
import app.utility.Utility;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

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

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public RegistrationRequest saveRegistrationRequest(RegistrationRequest request) { return registrationRequestRepository.save(request); }

    @Override
    public List<RegistrationRequest> findAll() { return registrationRequestRepository.findAll(); }

    @Override
    public ApplicationUser approveRegistration(RegistrationRequest registrationRequest) throws Exception {
        Utility.sendMail(registrationRequest.getEmail(), "Approved", "Your registration request has been approved.");

        registrationRequestRepository.deleteById(registrationRequest.getId());

        if(registrationRequest.getUserType().equals(UserType.COTTAGE_OWNER))
            return cottageOwnerRepository.save(new CottageOwner(registrationRequest.getEmail(), registrationRequest.getPassword(),
                    registrationRequest.getName(), registrationRequest.getLastName(), registrationRequest.getAddress(), registrationRequest.getCity(),
                    registrationRequest.getCountry(), registrationRequest.getPhoneNumber()));
        if(registrationRequest.getUserType().equals(UserType.SHIP_OWNER))
            return shipOwnerRepository.save(new ShipOwner(registrationRequest.getEmail(), registrationRequest.getPassword(), registrationRequest.getName(), registrationRequest.getLastName(),
                    registrationRequest.getAddress(), registrationRequest.getCity(), registrationRequest.getCountry(), registrationRequest.getPhoneNumber()));
        if(registrationRequest.getUserType().equals(UserType.INSTRUCTOR))
            return instructorRepository.save(new Instructor(registrationRequest.getEmail(), registrationRequest.getPassword(), registrationRequest.getName(), registrationRequest.getLastName(),
                    registrationRequest.getAddress(), registrationRequest.getCity(), registrationRequest.getCountry(), registrationRequest.getPhoneNumber()));

        return null;
    }

    @Override
    public void registerClient(UserRequest dto, String siteURL) throws UnsupportedEncodingException, MessagingException {
        String randomCode = RandomString.make(64);
        Client client = new Client(dto.getEmail(), passwordEncoder.encode(dto.getPassword()), dto.getFirstName(), dto.getLastName(), dto.getAddress(),
                dto.getCity(), dto.getCountry(), dto.getPhoneNumber());
        client.setVerificationCode(randomCode);

        List<Role> roles = roleService.findByName("ROLE_USER");
        client.setRoles(roles);

        clientRepository.save(client);

        sendVerificationEmail(client, siteURL);
    }

    @Override
    public void ejectRegistration(EjectRegistrationRequestDTO dto) throws MessagingException, UnsupportedEncodingException {
        Utility.sendMail(dto.getClientEmail(), "Eject", dto.getEjectExplanation());

        registrationRequestRepository.deleteById(dto.getRequestId());
    }

    @Override
    public Administrator registerAdmin(UserToRegisterDto dto) {
        return administratorRepository.save(new Administrator(dto.getEmail(), dto.getPassword(),
                dto.getName(), dto.getLastName(), dto.getAddress(), dto.getCity(),
                dto.getCountry(), dto.getPhoneNumber()));
    }
    
    public void sendVerificationEmail(Client client, String siteURL) throws MessagingException, UnsupportedEncodingException{
        String toAddress = client.getEmail();
        String fromAddress = "isatestmail2021@gmail.com";
        String senderName = "ISA project";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", client.getName());
        String verifyURL = siteURL + "/api/registration" + "/verify?code=" + client.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);
    }

    @Override
    public boolean verify(String verificationCode) {
        Client client = clientRepository.findByVerificationCode(verificationCode);

        if (client == null || client.isEnabled()) {
            return false;
        } else {
            client.setVerificationCode(null);
            client.setIsEnabled(true);
            clientRepository.save(client);

            return true;
        }

    }
}
