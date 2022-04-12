package app.controller;

import app.domain.Administrator;
import app.domain.RegistrationRequest;
import app.domain.ApplicationUser;
import app.domain.enums.UserType;
import app.dto.ClientDTO;
import app.dto.EjectRegistrationRequestDTO;
import app.dto.UserToRegisterDto;
import app.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/getRegistrationRequests")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<RegistrationRequest>> getRequests() {
        Collection<RegistrationRequest> greetings = registrationService.findAll();
        return new ResponseEntity<Collection<RegistrationRequest>>(greetings, HttpStatus.OK);
    }

    @RequestMapping("/createRegistrationRequest")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistrationRequest> createGreeting(@RequestBody RegistrationRequest registrationRequest) throws Exception {
        RegistrationRequest savedRequest = registrationService.saveRegistrationRequest(registrationRequest);
        return new ResponseEntity<RegistrationRequest>(savedRequest, HttpStatus.CREATED);
    }

    @RequestMapping("/approveRegistration")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicationUser> approveRegistration(@RequestBody RegistrationRequest registrationRequest) throws Exception {
        ApplicationUser savedUser = registrationService.approveRegistration(registrationRequest);
        return new ResponseEntity<ApplicationUser>(savedUser, HttpStatus.CREATED);
    }

    @RequestMapping("/ejectRegistration")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> ejectRegistration(@RequestBody EjectRegistrationRequestDTO dto) throws MessagingException, UnsupportedEncodingException {
        registrationService.ejectRegistration(dto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping("/registerAdmin")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Administrator> registerAdmin(@RequestBody UserToRegisterDto dto) throws Exception {
        Administrator savedAdmin = registrationService.registerAdmin(dto);
        return new ResponseEntity<Administrator>(savedAdmin, HttpStatus.CREATED);
    }
    
    @RequestMapping("/registerClient")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String processRegister(@RequestBody ClientDTO dto, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        registrationService.registerClient(dto, getSiteURL(request));
        return "register_success";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @RequestMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        boolean verified = registrationService.verify(code);
        return verified ?
                "    <title>Verification succeeded!</title>\n" +
                "    <div class=\"container text-center\">\n" +
                "        <h3>Congratulations, your account has been verified.</h3>\n" +
                "        <h4><a href=\"http://localhost:4200\">Click here to Login</a></h4>\n" +
                "    </div>"
                :
                "    <title>Verification failed</title>\n" +
                "    <div class=\"container text-center\">\n" +
                "        <h3>Sorry, we could not verify account. It maybe already verified,\n" +
                "            or verification code is incorrect.</h3>\n" +
                "    </div>";
    }
}
