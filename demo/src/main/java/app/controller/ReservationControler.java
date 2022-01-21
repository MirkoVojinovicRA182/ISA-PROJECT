package app.controller;

import app.domain.AdventureReservation;
import app.domain.ApplicationUser;
import app.domain.RegistrationRequest;
import app.dto.*;
import app.service.AdventureReservationService;
import app.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
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
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  processRegister(@RequestBody AdventureReservationDTO dto, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        if(adventureReservationService.bookAnInstructorAdventure(dto))
            return new ResponseEntity<String>("Created.", HttpStatus.CREATED);

        return new ResponseEntity<String>("Failed!", HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/getInstructorReservations/{id}")
    public ResponseEntity<List<AdventureReservationDTO>> getInstructorAdventures(@PathVariable Integer id){
        return new ResponseEntity<List<AdventureReservationDTO>>(adventureReservationService.getInstructorReservations(id), HttpStatus.OK);
    }

    @RequestMapping("/createAdventureReservationReport")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAdventureReservationReport(@RequestBody AdventureReservationReportDTO dto){
        adventureReservationService.createAventureReservationReport(dto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("/generateInstructorSallary")
    public ResponseEntity<List<SallaryByDayDTO>> generateInstructorSallary(@RequestBody SallaryDTO dto){
        return new ResponseEntity<List<SallaryByDayDTO>>(adventureReservationService.getInstructorSallary(dto.getFromDate(), dto.getToDate(), dto.getInstructorId()), HttpStatus.OK);
    }

    @PostMapping("/sumSystemSallary")
    public ResponseEntity<List<SallaryByDayDTO>> sumSystemSallary(@RequestBody SallaryDTO dto){
        return new ResponseEntity<List<SallaryByDayDTO>>(adventureReservationService.sumSystemSallary(dto.getFromDate(), dto.getToDate()), HttpStatus.OK);
    }

    @PostMapping("/defineSystemSallary/{value}")
    public ResponseEntity<Void> defineSystemSallary(@PathVariable Double value){
        Utility.saveSystemSallary(value);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
