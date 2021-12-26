package app.controller;

import app.dto.InstructorAdventureDTO;
import app.dto.UserProfileDTO;
import app.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/entity")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @RequestMapping("/getAllInstructors")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserProfileDTO>> getAllInstructors(){
        return new ResponseEntity<List<UserProfileDTO>>(entityService.getAllInstructors(), HttpStatus.FOUND);
    }

    @RequestMapping("/getAllInstructorAdventures")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstructorAdventureDTO>> getAllInstructorAdventures(){
        return new ResponseEntity<List<InstructorAdventureDTO>>(entityService.getAllInstructorAdventures(), HttpStatus.FOUND);
    }
}
