package app.controller;

import app.domain.Cottage;
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

    @RequestMapping("/getCottageReservations/{cottageId}")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CottageReservationDTO>> getCottageReservations(@PathVariable Integer cottageId) {
        return new ResponseEntity<List<CottageReservationDTO>>(cottageReservationService.getCottageReservations(cottageId), HttpStatus.OK);
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

    @RequestMapping("/isCottageFree")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isCottageFree(@RequestBody ReservationDTO dto){
        return new ResponseEntity<Boolean>(cottageReservationService.isCottageFree(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/isShipFree")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isShipFree(@RequestBody ReservationDTO dto){
        return new ResponseEntity<Boolean>(shipReservationService.isShipFree(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/isAdventureFree")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isAdventureFree(@RequestBody ReservationDTO dto){
        return new ResponseEntity<Boolean>(adventureReservationService.isAdventureFree(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/bookAdventure")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdventureReservationDTO> bookAdventure(@RequestBody AdventureReservationDTO dto){
        return new ResponseEntity<AdventureReservationDTO>(adventureReservationService.bookAdventure(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/bookCottage")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageReservationDTO> bookCottage(@RequestBody CottageReservationDTO dto){
        return new ResponseEntity<CottageReservationDTO>(cottageReservationService.bookCottage(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/bookShip")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShipReservationDTO> bookShip(@RequestBody ShipReservationDTO dto){
        return new ResponseEntity<ShipReservationDTO>(shipReservationService.bookShip(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/getCottageHistoryReservations/{clientId}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservationHistoryDTO>> getHistoryReservations(@PathVariable Integer clientId){
        return new ResponseEntity<List<ReservationHistoryDTO>>(cottageReservationService.getHistoryReservations(clientId), HttpStatus.OK);
    }

    @RequestMapping("/getShipHistoryReservations/{clientId}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservationHistoryDTO>> getShipHistoryReservations(@PathVariable Integer clientId){
        return new ResponseEntity<List<ReservationHistoryDTO>>(shipReservationService.getShipHistoryReservations(clientId), HttpStatus.OK);
    }

    @RequestMapping("/getAdventureHistoryReservations/{clientId}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservationHistoryDTO>> getAdventureHistoryReservations(@PathVariable Integer clientId){
        return new ResponseEntity<List<ReservationHistoryDTO>>(adventureReservationService.getAdventureHistoryReservations(clientId), HttpStatus.OK);
    }

    @RequestMapping("/getCottageCurrentReservations/{clientId}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservationHistoryDTO>> getCurrentReservations(@PathVariable Integer clientId){
        return new ResponseEntity<List<ReservationHistoryDTO>>(cottageReservationService.getCurrentReservations(clientId), HttpStatus.OK);
    }

    @RequestMapping("/getShipCurrentReservations/{clientId}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservationHistoryDTO>> getShipCurrentReservations(@PathVariable Integer clientId){
        return new ResponseEntity<List<ReservationHistoryDTO>>(shipReservationService.getShipCurrentReservations(clientId), HttpStatus.OK);
    }

    @RequestMapping("/getAdventureCurrentReservations/{clientId}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservationHistoryDTO>> getAdventureCurrentReservations(@PathVariable Integer clientId){
        return new ResponseEntity<List<ReservationHistoryDTO>>(adventureReservationService.getAdventureCurrentReservations(clientId), HttpStatus.OK);
    }

    @DeleteMapping(value = "cancelCottageReservation/{cottageId}")
    public ResponseEntity<Void> cancelCottageReservation(@PathVariable Integer id) throws Exception {
        cottageReservationService.cancelCottageReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cancelShipReservation")
    public ResponseEntity<Void> cancelShipReservation(@PathVariable Integer id) throws Exception {
        shipReservationService.cancelShipReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cancelAdventureReservation")
    public ResponseEntity<Void> cancelAdventureReservation(@PathVariable Integer id) throws Exception {
        adventureReservationService.cancelAdventureReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
