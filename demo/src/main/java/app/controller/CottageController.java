package app.controller;

import app.domain.Mark;
import app.domain.Room;
import app.dto.CottageDTO;
import app.service.CottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api/cottage")
public class CottageController {

    @Autowired
    private CottageService cottageService;

    @RequestMapping("/createCottage")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> createCottage(@RequestBody CottageDTO cottageDto) throws Exception {
        cottageService.saveCottage(cottageDto);
        return new ResponseEntity<>(cottageDto, HttpStatus.CREATED);
    }

    /*@RequestMapping("/updateCottage")*/
    @PutMapping(value = "/updateCottage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> changeCottage(@RequestBody CottageDTO cottageDto) throws Exception {
        cottageService.updateCottage(cottageDto);
        return new ResponseEntity<>(cottageDto, HttpStatus.OK);
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

    @RequestMapping("/addImage/{cottageId}/{imgUrl}")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> addImage(@PathVariable Integer cottageId, @RequestBody Set<String> imgUrl) throws Exception {
        return new ResponseEntity<>(cottageService.addImage(cottageId, imgUrl), HttpStatus.OK);
    }

    @RequestMapping("/addRoom/{cottageId}")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> addRoom(@PathVariable Integer cottageId, @RequestBody Set<Room> rooms) throws Exception {
        return new ResponseEntity<>(cottageService.addRoom(cottageId, rooms), HttpStatus.OK);
    }

    @RequestMapping("/rateCottage/{cottageId}")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> rateCottage(@PathVariable Integer cottageId, @RequestBody Mark mark) throws Exception {
        return new ResponseEntity<>(cottageService.rateCottage(cottageId, mark), HttpStatus.OK);
    }

}
