package app.controller;

import app.domain.RegistrationRequest;
import app.dto.InstructorAdventureDTO;
import app.dto.InstructorBusynessDTO;
import app.service.InstructorBusynessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/instructorBusyness")
public class InstructorBusynessController {

    @Autowired
    private InstructorBusynessService instructorBusynessService;

    @RequestMapping("/addBusynessInterval")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstructorBusynessDTO> addBusynessInterval(@RequestBody InstructorBusynessDTO interval) throws Exception {
        return new ResponseEntity<InstructorBusynessDTO>(instructorBusynessService.addBusynessInterval(interval), HttpStatus.CREATED);
    }

    @RequestMapping("/getInstructorBusynessIntervals/{instructorId}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstructorBusynessDTO>> getInstructorBusynessIntervals(@PathVariable Integer instructorId){
        return new ResponseEntity<List<InstructorBusynessDTO>>(instructorBusynessService.getInstructorBusynessIntervals(instructorId), HttpStatus.OK);
    }
}
