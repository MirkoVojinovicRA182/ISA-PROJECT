package app.controller;

import app.dto.SubscriptionDTO;
import app.repository.ClientRepository;
import app.repository.CottageSubscriptionRepository;
import app.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/client")
public class ClientControler {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ActionService actionService;

    @Autowired
    CottageSubscriptionRepository subscriptionRepository;

    @PutMapping(value = "/adventureSubscribe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriptionDTO> adventureSubscribe(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<SubscriptionDTO>(actionService.adventureSubscribe(subscriptionDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/adventureUnSubscribe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriptionDTO> adventureUnSubscribe(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<SubscriptionDTO>(actionService.adventureUnSubscribe(subscriptionDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/shipSubscribe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriptionDTO> shipSubscribe(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<SubscriptionDTO>(actionService.shipSubscribe(subscriptionDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/shipUnSubscribe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriptionDTO> shipUnSubscribe(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<SubscriptionDTO>(actionService.shipUnSubscribe(subscriptionDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/cottageSubscribe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriptionDTO> cottageSubscribe(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<SubscriptionDTO>(actionService.cottageSubscribe(subscriptionDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/cottageUnSubscribe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriptionDTO> cottageUnSubscribe(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<SubscriptionDTO>(actionService.cottageUnSubscribe(subscriptionDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/userSubscribe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriptionDTO> userSubscribe(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<SubscriptionDTO>(actionService.userSubscribe(subscriptionDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/userUnSubscribe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriptionDTO> userUnSubscribe(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<SubscriptionDTO>(actionService.userUnSubscribe(subscriptionDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/getCottagesSubscriptions")
    public ResponseEntity<List<SubscriptionDTO>> getCottagesSubscriptions(){
        return new ResponseEntity<List<SubscriptionDTO>>(actionService.getCottagesSubscriptions(), HttpStatus.OK);
    }

    @GetMapping(value = "/getAdventuresSubscriptions")
    public ResponseEntity<List<SubscriptionDTO>> getAdventuresSubscriptions(){
        return new ResponseEntity<List<SubscriptionDTO>>(actionService.getAdventuresSubscriptions(), HttpStatus.OK);
    }

    @GetMapping(value = "/getShipsSubscriptions")
    public ResponseEntity<List<SubscriptionDTO>> getShipsSubscriptions(){
        return new ResponseEntity<List<SubscriptionDTO>>(actionService.getShipsSubscriptions(), HttpStatus.OK);
    }

    @GetMapping(value = "/getUserSubscriptions")
    public ResponseEntity<List<SubscriptionDTO>> getUserSubscriptions(){
        return new ResponseEntity<List<SubscriptionDTO>>(actionService.getUserSubscriptions(), HttpStatus.OK);
    }

    @PutMapping(value = "/isSubscribedToCottage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isSubscribedToCottage(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<Boolean>(actionService.isSubscribedToCottage(subscriptionDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/isSubscribedToAdventure", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isSubscribedToAdventure(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<Boolean>(actionService.isSubscribedToAdventure(subscriptionDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/isSubscribedToShip", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isSubscribedToShip(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<Boolean>(actionService.isSubscribedToShip(subscriptionDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/isSubscribedToUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isSubscribedToUser(@RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
        return new ResponseEntity<Boolean>(actionService.isSubscribedToUser(subscriptionDTO), HttpStatus.OK);
    }
}
