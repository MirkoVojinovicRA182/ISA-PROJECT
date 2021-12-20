package app.controller;

import app.domain.Instructor;
import app.domain.InstructorAdventure;
import app.domain.RegistrationRequest;
import app.dto.InstructorAdventureDTO;
import app.service.InstructorAdventureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructorAdventure")
public class InstructorAdventureController {

    @Autowired
    private InstructorAdventureService instructorAdventureService;

    @RequestMapping("/createInstructorAdventure")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstructorAdventureDTO> createGreeting(@RequestBody InstructorAdventureDTO dto) throws Exception {
        instructorAdventureService.saveAdventure(dto);
        return new ResponseEntity<InstructorAdventureDTO>(dto, HttpStatus.CREATED);
    }
}
