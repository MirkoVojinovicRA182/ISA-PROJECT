package app.controller;

import app.dto.*;
import app.service.AdventureReservationService;
import app.service.CottageReservationService;
import app.dto.AdventureReservationDTO;
import app.dto.AdventureReservationSearchDTO;
import app.dto.ShipReservationDTO;
import app.dto.ShipReservationSearchDTO;
import app.service.ShipReservationService;
import app.domain.AdventureReservation;
import app.domain.ApplicationUser;
import app.domain.RegistrationRequest;
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
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/reservation")
public class ReservationControler {

    @Autowired
    private AdventureReservationService adventureReservationService;

    @Autowired
    private ShipReservationService shipReservationService;

    @Autowired
    private CottageReservationService cottageReservationService;

    //ADVENTURES
    @RequestMapping("/getFreeAdventures")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdventureReservationDTO>> getFreeAdventures(@RequestBody AdventureReservationSearchDTO dto) {
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

    /*@RequestMapping("/createAdventureReservationReport")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String adventureReservation(@RequestBody AdventureReservationDTO dto, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        adventureReservationService.bookAnInstructorAdventure(dto);
        return "adventure_reservation_success";
    }*/

    //SHIPS
    @RequestMapping("/getFreeShips")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ShipReservationDTO>> getFreeShips(@RequestBody ShipReservationSearchDTO dto) {
        List<ShipReservationDTO> freeShips = shipReservationService.getFreeShips(dto);
        return new ResponseEntity<List<ShipReservationDTO>>(freeShips, HttpStatus.OK);
    }

    @RequestMapping("/shipReservation")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String shipReservation(@RequestBody ShipReservationDTO dto, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        shipReservationService.bookAShip(dto);
        return "ship_reservation_success";
    }

    //COTTAGES
    @RequestMapping("/getFreeCottages")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CottageReservationDTO>> getFreeCottages(@RequestBody CottageReservationSearchDTO dto) {
        List<CottageReservationDTO> freeCottages = cottageReservationService.getFreeCottages(dto);
        return new ResponseEntity<List<CottageReservationDTO>>(freeCottages, HttpStatus.OK);
    }

    @RequestMapping("/cottageReservation")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String cottageReservation(@RequestBody CottageReservationDTO dto, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        cottageReservationService.bookACottage(dto);
        return "cottage_reservation_success";
    }

    @RequestMapping("/reserveCottage")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageReservationDTO> reserveCottage(@RequestBody CottageReservationDTO dto) throws Exception {
        return new ResponseEntity<>(cottageReservationService.reserveCottage(dto), HttpStatus.OK);
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

    @PostMapping("/getReservationStatistics")
    public ResponseEntity<List<ReservationStatisticsDTO>> getReservationStatistics(@RequestBody StatsDateRangeDTO dto){
        return new ResponseEntity<List<ReservationStatisticsDTO>>(adventureReservationService.getReservationStatistics(dto.getFromDate(), dto.getToDate(), dto.getUserId()), HttpStatus.OK);
    }

}
