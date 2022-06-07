package app.controller;

import app.domain.ApplicationUser;
import app.domain.RegistrationRequest;
import app.domain.enums.UserType;
import app.dto.*;
import app.service.UserService;
import org.apache.catalina.User;
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

    @GetMapping(value = "/getClient/{username}")
    public ResponseEntity<UserProfileDTO> getClient(@PathVariable String username){
        return new ResponseEntity<UserProfileDTO>(userService.getClient(username), HttpStatus.OK);
    }

    @GetMapping(value = "/getCottageOwner/{username}")
    public ResponseEntity<UserProfileDTO> getCottageOwner(@PathVariable String username){
        return new ResponseEntity<UserProfileDTO>(userService.getCottageOwner(username), HttpStatus.OK);
    }

    @PutMapping(value = "/updateCottageOwner")
    public ResponseEntity<UserProfileDTO> updateCottageOwner(@RequestBody UserProfileDTO userProfileDTO){
        return new ResponseEntity<UserProfileDTO>(userService.updateCottageOwner(userProfileDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<Void> deleteUser(@RequestParam Integer userId, @RequestParam UserType userType){
        userService.deleteUser(userId, userType);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping("/rateAdventure")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RatingDTO> rateEntity(@RequestBody RatingDTO dto){
        return new ResponseEntity<RatingDTO>(userService.rateAdventure(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/rateShip")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RatingDTO> rateShip(@RequestBody RatingDTO dto){
        return new ResponseEntity<RatingDTO>(userService.rateShip(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/rateCottage")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RatingDTO> rateCottage(@RequestBody RatingDTO dto){
        return new ResponseEntity<RatingDTO>(userService.rateCottage(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/complaintCottage")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComplaintDTO> complaintCottage(@RequestBody ComplaintDTO dto){
        return new ResponseEntity<ComplaintDTO>(userService.complaintCottage(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/complaintShip")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComplaintDTO> complaintShip(@RequestBody ComplaintDTO dto){
        return new ResponseEntity<ComplaintDTO>(userService.complaintShip(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/complaintAdventure")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComplaintDTO> complaintAdventure(@RequestBody ComplaintDTO dto){
        return new ResponseEntity<ComplaintDTO>(userService.complaintAdventure(dto), HttpStatus.CREATED);
    }
}
