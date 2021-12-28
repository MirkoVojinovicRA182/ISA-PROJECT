package app.controller;

import app.domain.ApplicationUser;
import app.dto.InstructorAdventureDTO;
import app.dto.LoginDTO;
import app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/getUser")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicationUser> getUser(@RequestBody LoginDTO dto){
        return new ResponseEntity<ApplicationUser>(loginService.getUser(dto), HttpStatus.OK);
    }
}
