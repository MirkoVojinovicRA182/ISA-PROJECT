package app.controller;

import app.dto.*;
import app.service.AdventureReservationService;
import app.service.CottageReservationService;
import app.service.ShipReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String adventureReservation(@RequestBody AdventureReservationDTO dto, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        adventureReservationService.bookAnInstructorAdventure(dto);
        return "adventure_reservation_success";
    }

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
}
