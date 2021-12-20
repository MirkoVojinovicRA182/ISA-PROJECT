package app.controller;

import app.domain.Body;
import app.domain.Organ;
import app.domain.RegistrationRequest;
import app.dto.OrganDTO;
import app.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/createBody")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Body> createGreeting(@RequestBody Body body) throws Exception {
        testService.saveBody(body);
        return new ResponseEntity<Body>(body, HttpStatus.CREATED);
    }

    @RequestMapping("/createOrgan")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrganDTO> createGreeting(@RequestBody OrganDTO dto) throws Exception {
        testService.saveOrgan(dto);
        return new ResponseEntity<OrganDTO>(dto, HttpStatus.CREATED);
    }

    @RequestMapping("/getBody")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Body> getBody(){
        return new ResponseEntity<Body>(testService.getBody(), HttpStatus.OK);
    }
}
