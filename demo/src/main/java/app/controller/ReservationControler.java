package app.controller;

import app.domain.AdventureReservation;
import app.domain.ApplicationUser;
import app.domain.RegistrationRequest;
import app.dto.AdventureReservationDTO;
import app.dto.AdventureReservationReportDTO;
import app.dto.ClientDTO;
import app.dto.ReservationSearchDTO;
import app.service.AdventureReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/reservation")
public class ReservationControler {

    @Autowired
    private AdventureReservationService adventureReservationService;

    @RequestMapping("/getFreeAdventures")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdventureReservationDTO>> getFreeAdventures(@RequestBody ReservationSearchDTO dto) {
        List<AdventureReservationDTO> freeAdventures = adventureReservationService.getFreeAdventures(dto);
        return new ResponseEntity<List<AdventureReservationDTO>>(freeAdventures, HttpStatus.OK);
    }

    @RequestMapping("/adventureReservation")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String processRegister(@RequestBody AdventureReservationDTO dto, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        adventureReservationService.bookAnInstructorAdventure(dto);
        return "adventure_reservation_success";
    }

    @GetMapping("/getInstructorReservations/{id}")
    public ResponseEntity<List<AdventureReservationDTO>> getInstructorAdventures(@PathVariable Integer id){
        return new ResponseEntity<List<AdventureReservationDTO>>(adventureReservationService.getInstructorReservations(id), HttpStatus.OK);
    }

    @RequestMapping("/createAventureReservationReport")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAventureReservationReport(@RequestBody AdventureReservationReportDTO dto){
        adventureReservationService.createAventureReservationReport(dto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
