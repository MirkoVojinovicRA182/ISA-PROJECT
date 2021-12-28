package app.controller;

import app.domain.Administrator;
import app.domain.RegistrationRequest;
import app.domain.ApplicationUser;
import app.domain.enums.UserType;
import app.dto.UserToRegisterDto;
import app.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ApplicationUser> approveRegistration(@RequestBody UserToRegisterDto dto) throws Exception {
        ApplicationUser savedUser = registrationService.approveRegistration(dto);
        return new ResponseEntity<ApplicationUser>(savedUser, HttpStatus.CREATED);
    }

    @RequestMapping("/ejectRegistration")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> ejectRegistration(String email) {
        registrationService.ejectRegistration(email);
        return new ResponseEntity<String>("Mail is sent!", HttpStatus.OK);
    }

    @RequestMapping("/registerAdmin")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Administrator> registerAdmin(@RequestBody UserToRegisterDto dto) throws Exception {
        Administrator savedAdmin = registrationService.registerAdmin(dto);
        return new ResponseEntity<Administrator>(savedAdmin, HttpStatus.CREATED);
    }
}
