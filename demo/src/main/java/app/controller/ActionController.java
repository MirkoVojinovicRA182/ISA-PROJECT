package app.controller;

import app.dto.ActionAdventureDTO;
import app.dto.ReservationHistoryDTO;
import app.service.ActionService;
import app.service.AdventureReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/action")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @Autowired
    private AdventureReservationService adventureReservationService;

    @PostMapping(value = "/createAdventureAction")
    public ResponseEntity<String> createAdventureAction(@RequestBody ActionAdventureDTO dto) {
        if(actionService.createAdventureAction(dto))
            return new ResponseEntity<String>("Created", HttpStatus.CREATED);

        return new ResponseEntity<String>("Failed.", HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping(value = "/getByAdventureId/{id}")
    public ResponseEntity<List<ActionAdventureDTO>> createAdventureAction(@PathVariable Integer id) {
        return new ResponseEntity<List<ActionAdventureDTO>>(actionService.getActionsByAdventureId(id), HttpStatus.OK);
    }

}
