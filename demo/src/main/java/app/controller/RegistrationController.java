package app.controller;

import app.domain.RegistrationRequest;
import app.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
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
    public ResponseEntity<RegistrationRequest> createGreeting(@RequestBody RegistrationRequest greeting) throws Exception {
        RegistrationRequest savedRequest = registrationService.createRegistrationRequest(greeting);
        return new ResponseEntity<RegistrationRequest>(savedRequest, HttpStatus.CREATED);
    }
}
