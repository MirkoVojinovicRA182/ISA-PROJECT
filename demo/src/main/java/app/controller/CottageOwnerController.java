package app.controller;

import app.dto.CottageOwnerDTO;
import app.service.CottageOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cottageOwner")
public class CottageOwnerController {

    @Autowired
    private CottageOwnerService cottageOwnerService;

    @RequestMapping("/createCottageOwner")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageOwnerDTO> createCottageOwner(@RequestBody CottageOwnerDTO cottageOwnerDto) throws Exception {
        cottageOwnerService.saveCottageOwner(cottageOwnerDto);
        return new ResponseEntity<>(cottageOwnerDto, HttpStatus.CREATED);
    }

    @RequestMapping("/updateCottageOwner")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageOwnerDTO> changeCottage(@RequestBody CottageOwnerDTO cottageOwnerDto) throws Exception {
        cottageOwnerService.updateCottageOwner(cottageOwnerDto);
        return new ResponseEntity<>(cottageOwnerDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteCottageOwner/{cottageOwnerId}")
    public ResponseEntity<Void> deleteCottageOwner(@PathVariable Integer cottageOwnerId) throws Exception {
        cottageOwnerService.deleteCottageOwner(cottageOwnerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
