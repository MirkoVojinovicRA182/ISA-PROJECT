package app.controller;

import app.domain.CottageImage;
import app.domain.Mark;
import app.domain.Room;
import app.dto.*;
import app.service.CottageReservationService;
import app.service.CottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200"/*, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}*/)
@RequestMapping("/api/cottage")
public class CottageController {

    @Autowired
    private CottageService cottageService;
    @Autowired
    CottageReservationService cottageReservationService;

    @RequestMapping("/createCottage")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> createCottage(@RequestBody ChangeCottageDTO cottageDto) throws Exception {
        return new ResponseEntity<>(cottageService.saveCottage(cottageDto), HttpStatus.OK);
    }

    /*@RequestMapping("/updateCottage")*/
    @PutMapping(value = "/updateCottage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> changeCottage(@RequestBody ChangeCottageDTO cottageDto) throws Exception {
        cottageService.updateCottage(cottageDto);
        return new ResponseEntity<>(cottageService.getCottageById(cottageDto.getCottageId()), HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteCottage/{cottageId}")
    public ResponseEntity<Void> deleteCottage(@PathVariable Integer cottageId) throws Exception {
        cottageService.deleteCottage(cottageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/searchCottage/{cottageOwnerId}/{searchFilter}")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CottageDTO>> searchCottage(@PathVariable Integer cottageOwnerId, @PathVariable String searchFilter) throws Exception {
        return new ResponseEntity<>(cottageService.searchCottage(cottageOwnerId, searchFilter), HttpStatus.OK);
    }

    @RequestMapping("/cottageOwnerCottages/{cottageOwnerUsername}")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CottageDTO>> getCottageOwnerCottages(@PathVariable String cottageOwnerUsername) throws Exception{
        return new ResponseEntity<>(cottageService.getCottageOwnerCottager(cottageOwnerUsername), HttpStatus.OK);
    }

    @RequestMapping("/getCottage/{cottageId}")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> getCottage(@PathVariable Integer cottageId) throws Exception {
        return new ResponseEntity<>(cottageService.getCottageById(cottageId), HttpStatus.OK);
    }

    @PutMapping(value = "/addImage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> addImage(@RequestBody Set<CottageImageDTO> img) throws Exception {
        return new ResponseEntity<>(cottageService.addImage(img), HttpStatus.OK);
    }

    @RequestMapping("/removeImage")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> removeImage(@RequestBody CottageImageDTO img) throws Exception {
        return new ResponseEntity<>(cottageService.removeImage(img), HttpStatus.OK);
    }

    @RequestMapping("/addRoom")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> addRoom(@RequestBody Set<RoomDTO> rooms) throws Exception {
        return new ResponseEntity<>(cottageService.addRoom(rooms), HttpStatus.OK);
    }

    @RequestMapping("/addCottageAvailability")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> addCottageAvailability(@RequestBody Set<CottageAvailabilityDTO> availability) throws Exception {
        return new ResponseEntity<>(cottageService.addCottageAvailability(availability), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteCottageAvailability/{availabilityId}")
    public ResponseEntity<Void> deleteCottageAvailability(@PathVariable Integer availabilityId) throws Exception {
        cottageService.deleteCottageAvailability(availabilityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/rateCottage")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> rateCottage( @RequestBody MarkDTO mark) throws Exception {
        return new ResponseEntity<>(cottageService.rateCottage(mark), HttpStatus.OK);
    }

    @RequestMapping("/addUsersReservated/{cottageOwnerId}")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allUserReservated(@PathVariable Integer cottageOwnerId) throws Exception {
        return new ResponseEntity<>(cottageReservationService.getAllUserEverReservated(cottageOwnerId), HttpStatus.OK);
    }

    @RequestMapping("/createAction")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAction(@RequestBody ActionCottageDTO action) throws Exception {
        return new ResponseEntity<>(cottageReservationService.createActionCottage(action), HttpStatus.CREATED);
    }

    @RequestMapping("/createReport")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createReport(@RequestBody CottageReservationReportDTO dto) throws Exception {
        return new ResponseEntity<>(cottageService.createReport(dto), HttpStatus.CREATED);
    }

    @RequestMapping("/finished/{cottageId}")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFinished(@PathVariable Integer cottageId) throws Exception {
        return new ResponseEntity<>(cottageReservationService.getFinished(cottageId), HttpStatus.CREATED);
    }

    @RequestMapping("/reservations/{cottageId}")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getForCottage(@PathVariable Integer cottageId) throws Exception {
        return new ResponseEntity<>(cottageReservationService.getForCottage(cottageId), HttpStatus.CREATED);
    }
    
}
