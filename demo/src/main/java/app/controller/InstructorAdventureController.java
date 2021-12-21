package app.controller;

import app.dto.InstructorAdventureDTO;
import app.service.InstructorAdventureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructorAdventure")
public class InstructorAdventureController {

    @Autowired
    private InstructorAdventureService instructorAdventureService;

    @RequestMapping("/createInstructorAdventure")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstructorAdventureDTO> createAdventure(@RequestBody InstructorAdventureDTO dto) throws Exception {
        instructorAdventureService.saveAdventure(dto);
        return new ResponseEntity<InstructorAdventureDTO>(dto, HttpStatus.CREATED);
    }

    @RequestMapping("/getAdventures/{instructorId}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstructorAdventureDTO>> getAdventuresByInstructorId(@PathVariable Integer instructorId){
        return new ResponseEntity<List<InstructorAdventureDTO>>(instructorAdventureService.getAdventuresByInstructorId(instructorId), HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteAdventure/{adventureId}")
    public ResponseEntity<Void> deleteAdventure(@PathVariable Integer adventureId){
        instructorAdventureService.deleteAdventure(adventureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
