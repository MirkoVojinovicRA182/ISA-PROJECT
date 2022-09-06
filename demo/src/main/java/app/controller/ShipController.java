package app.controller;

import app.domain.Ship;
import app.dto.CottageDTO;
import app.dto.CottageImageDTO;
import app.dto.ShipDTO;
import app.service.ShipService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ship")
public class ShipController {
    @Autowired
    private ShipService shipService;

    @RequestMapping("/createShip")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShipDTO> createCottage(@RequestBody ShipDTO shipDto) throws Exception {
        shipService.saveShip(shipDto);
        return new ResponseEntity<>(shipDto, HttpStatus.CREATED);
    }

    //@RequestMapping("/updateShip")
    @PutMapping(value = "/updateShip",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changeCottage(@RequestBody ShipDTO shipDto) throws Exception {
        shipService.updateShip(shipDto);
        return new ResponseEntity<>(shipDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteShip/{shipId}")
    public ResponseEntity<Void> deleteCottage(@PathVariable Integer shipId) throws Exception {
        shipService.deleteShip(shipId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/getShip/{shipId}")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShipDTO> getShip(@PathVariable Integer shipId) throws Exception {
        return new ResponseEntity<ShipDTO>(shipService.getShipById(shipId), HttpStatus.OK);
    }
    
    @RequestMapping("/getUserShips/{userId}")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserShips(@PathVariable Integer userId) throws Exception {
        return new ResponseEntity<>(shipService.getUserShips(userId), HttpStatus.OK);
    }
    
    @PutMapping(value = "/addImage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addImage(@RequestBody Set<CottageImageDTO> img) throws Exception {
        return new ResponseEntity<>(shipService.addImage(img), HttpStatus.OK);
    }

    @RequestMapping("/removeImage")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> removeImage(@RequestBody CottageImageDTO img) throws Exception {
        return new ResponseEntity<>(shipService.removeImage(img), HttpStatus.OK);
    }
}
