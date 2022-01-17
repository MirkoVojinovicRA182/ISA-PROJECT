package app.service;

import app.domain.*;
import app.domain.enums.UserType;
import app.dto.ClientDTO;
import app.dto.UserToRegisterDto;
import app.repository.*;
import app.utility.Utility;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
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

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public RegistrationRequest saveRegistrationRequest(RegistrationRequest request) { return registrationRequestRepository.save(request); }

    @Override
    public List<RegistrationRequest> findAll() { return registrationRequestRepository.findAll(); }

    @Override
    public ApplicationUser approveRegistration(RegistrationRequest registrationRequest) throws Exception {
        //Utility.sendMail(registrationRequest.getEmail(), "Approved", "Your registration request has been approved.");

        registrationRequestRepository.deleteById(registrationRequest.getId());

        if(registrationRequest.getUserType().equals(UserType.CottageOwner))
            return cottageOwnerRepository.save(new CottageOwner(registrationRequest.getEmail(), registrationRequest.getPassword(),
                    registrationRequest.getName(), registrationRequest.getLastName(), registrationRequest.getAddress(), registrationRequest.getCity(),
                    registrationRequest.getCountry(), registrationRequest.getPhoneNumber()));
        if(registrationRequest.getUserType().equals(UserType.ShipOwner))
            return shipOwnerRepository.save(new ShipOwner(registrationRequest.getEmail(), registrationRequest.getPassword(), registrationRequest.getName(), registrationRequest.getLastName(),
                    registrationRequest.getAddress(), registrationRequest.getCity(), registrationRequest.getCountry(), registrationRequest.getPhoneNumber()));
        if(registrationRequest.getUserType().equals(UserType.Instructor))
            return instructorRepository.save(new Instructor(registrationRequest.getEmail(), registrationRequest.getPassword(), registrationRequest.getName(), registrationRequest.getLastName(),
                    registrationRequest.getAddress(), registrationRequest.getCity(), registrationRequest.getCountry(), registrationRequest.getPhoneNumber()));

        return null;
    }

    @Override
    public void registerClient(ClientDTO dto, String siteURL) throws UnsupportedEncodingException, MessagingException {
        String randomCode = RandomString.make(64);
        Client client = new Client(dto.getEmail(), dto.getPassword(), dto.getName(), dto.getLastName(), dto.getAddress(),
                dto.getCity(), dto.getCountry(), dto.getPhoneNumber());
        client.setVerificationCode(randomCode);

        clientRepository.save(client);

        sendVerificationEmail(client, siteURL);
    }

    @Override
    public void ejectRegistration(RegistrationRequest registrationRequest) {
        //Utility.sendMail(registrationRequest.getEmail(), "Eject", "Your registration request has been denied.");

        registrationRequestRepository.deleteById(registrationRequest.getId());
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
            client.setEnabled(true);
            clientRepository.save(client);

            return true;
        }

    }
}
