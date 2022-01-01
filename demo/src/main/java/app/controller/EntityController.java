package app.controller;

import app.dto.InstructorAdventureDTO;
import app.dto.UserProfileDTO;
import app.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/entity")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @RequestMapping("/getAllInstructors")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserProfileDTO>> getAllInstructors(){
        return new ResponseEntity<List<UserProfileDTO>>(entityService.getAllInstructors(), HttpStatus.FOUND);
    }

    @RequestMapping("/getInstructor/{id}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfileDTO> getInstructor(@PathVariable Integer id){
        return new ResponseEntity<UserProfileDTO>(entityService.getInstructorById(id), HttpStatus.OK);
    }

    @RequestMapping("/getAdministrator/{id}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfileDTO> getAdministrator(@PathVariable Integer id){
        return new ResponseEntity<UserProfileDTO>(entityService.getAdministratorById(id), HttpStatus.OK);
    }

    @RequestMapping("/getAllAdventures")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstructorAdventureDTO>> getAllInstructorAdventures(){
        return new ResponseEntity<List<InstructorAdventureDTO>>(entityService.getAllInstructorAdventures(), HttpStatus.OK);
    }
}
