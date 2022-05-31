package app.controller;

import app.dto.InstructorAdventureDTO;
import app.dto.UserPasswordDTO;
import app.dto.UserProfileDTO;
import app.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/userProfile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;


    @RequestMapping("/updatePersonalInfo")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfileDTO> updatePersonalInfo(@RequestBody UserProfileDTO dto){
        return new ResponseEntity<UserProfileDTO>(userProfileService.updatePersonalInfo(dto), HttpStatus.OK);
    }

    @RequestMapping("/updatePassword")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfileDTO> updatePassword(@RequestBody UserPasswordDTO userPasswordDTO){
        return new ResponseEntity<>(userProfileService.updatePassword(userPasswordDTO), HttpStatus.OK);
    }


}
