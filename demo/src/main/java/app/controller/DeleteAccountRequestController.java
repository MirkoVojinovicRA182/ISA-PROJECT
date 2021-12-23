package app.controller;

import app.domain.ApplicationUser;
import app.domain.RegistrationRequest;
import app.dto.DeleteAccountRequestDTO;
import app.dto.LoginDTO;
import app.service.DeleteAccountRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deleteAccount")
public class DeleteAccountRequestController {

    @Autowired
    private DeleteAccountRequestService deleteAccountRequestService;

    @RequestMapping("/createRequest")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeleteAccountRequestDTO> createRequest(@RequestBody DeleteAccountRequestDTO dto){
        deleteAccountRequestService.createRequest(dto);
        return new ResponseEntity<DeleteAccountRequestDTO>(dto, HttpStatus.OK);
    }

    @RequestMapping("/getRequests")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DeleteAccountRequestDTO>> getRequests(){
        return new ResponseEntity<List<DeleteAccountRequestDTO>>(deleteAccountRequestService.getRequests(), HttpStatus.OK);
    }
}
