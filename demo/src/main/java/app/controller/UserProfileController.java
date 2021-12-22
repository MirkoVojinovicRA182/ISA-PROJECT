package app.controller;

import app.dto.InstructorAdventureDTO;
import app.dto.UserProfileDTO;
import app.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userProfile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;


    @RequestMapping("/updateUserProfile")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfileDTO> updateUserProfile(@RequestBody UserProfileDTO dto){
        return new ResponseEntity<UserProfileDTO>(userProfileService.updateUserProfile(dto), HttpStatus.OK);
    }
}
