package app.controller;

import app.dto.AdventureAdditionalServiceDTO;
import app.dto.InstructorAdventureDTO;
import app.service.InstructorAdventureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/instructorAdventure")
public class InstructorAdventureController {

    @Autowired
    private InstructorAdventureService instructorAdventureService;

    @RequestMapping("/createInstructorAdventure")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstructorAdventureDTO> createAdventure(@RequestBody InstructorAdventureDTO dto){
        instructorAdventureService.saveAdventure(dto);
        return new ResponseEntity<InstructorAdventureDTO>(dto, HttpStatus.CREATED);
    }

    @RequestMapping("/createAdditionalService")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdventureAdditionalServiceDTO> createAdditionalService(@RequestBody AdventureAdditionalServiceDTO dto){
        instructorAdventureService.saveAdditionalService(dto);
        return new ResponseEntity<AdventureAdditionalServiceDTO>(dto, HttpStatus.CREATED);
    }

    @RequestMapping("/getAdventures/{instructorId}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstructorAdventureDTO>> getAdventuresByInstructorId(@PathVariable Integer instructorId){
        return new ResponseEntity<List<InstructorAdventureDTO>>(instructorAdventureService.getAdventuresByInstructorId(instructorId), HttpStatus.OK);
    }

    @RequestMapping("/getAdditionalServices/{adventureId}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdventureAdditionalServiceDTO>> getAdditionalServices(@PathVariable Integer adventureId){
        return new ResponseEntity<List<AdventureAdditionalServiceDTO>>(instructorAdventureService.getAdditionalServices(adventureId), HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteAdventure/{adventureId}")
    public ResponseEntity<Void> deleteAdventure(@PathVariable Integer adventureId){
        instructorAdventureService.deleteAdventure(adventureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/updateAdventure")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstructorAdventureDTO> updateAdventure(@RequestBody InstructorAdventureDTO dto){
        InstructorAdventureDTO instructorAdventureDTO = instructorAdventureService.updateAdventure(dto);
        return new ResponseEntity<InstructorAdventureDTO>(instructorAdventureDTO, HttpStatus.OK);
    }

    @RequestMapping("/getAdventureById/{id}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstructorAdventureDTO> getAdventureById(@PathVariable Integer id) {
        return new ResponseEntity<InstructorAdventureDTO>(instructorAdventureService.getAdventureById(id), HttpStatus.OK);
    }
}
