package app.controller;

import app.domain.ApplicationUser;
import app.domain.RegistrationRequest;
import app.domain.enums.UserType;
import app.dto.UserProfileDTO;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUsers")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<UserProfileDTO>> getUsers(){
        return new ResponseEntity<Collection<UserProfileDTO>>(userService.getUsers(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<Void> deleteUser(@RequestParam Integer userId, @RequestParam UserType userType){
        userService.deleteUser(userId, userType);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
