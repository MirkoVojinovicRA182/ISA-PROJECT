package app.controller;

import app.dto.CottageDTO;
import app.service.CottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @RequestMapping("/updateCottage")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> changeCottage(@RequestBody CottageDTO cottageDto) throws Exception {
        cottageService.updateCottage(cottageDto);
        return new ResponseEntity<>(cottageDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteCottage/{cottageId}")
    public ResponseEntity<Void> deleteCottage(@PathVariable Integer cottageId) throws Exception {
        cottageService.deleteCottage(cottageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/searchCottage/{searchFilter}")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CottageDTO>> searchCottage(@PathVariable String searchFilter) throws Exception {
        return new ResponseEntity<>(cottageService.searchCottage(searchFilter), HttpStatus.OK);
    }

}
