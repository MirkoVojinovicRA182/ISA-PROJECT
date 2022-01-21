package app.controller;

import app.domain.ApplicationUser;
import app.domain.RegistrationRequest;
import app.domain.enums.UserType;
import app.dto.DeleteAccountRequestDTO;
import app.dto.LoginDTO;
import app.service.DeleteAccountRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/deleteAccountRequest")
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

    @DeleteMapping(value = "/deleteAccount")
    public ResponseEntity<Void> deleteAccount(@RequestParam Integer userId, @RequestParam Integer requestId) throws MessagingException, UnsupportedEncodingException {
        DeleteAccountRequestDTO requestDTO = new DeleteAccountRequestDTO();
        requestDTO.setId(requestId);
        requestDTO.setUserId(userId);
        deleteAccountRequestService.deleteAccount(requestDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping( "/ejectDeleteRequest/{requestId}")
    public ResponseEntity<Void> ejectDeleteRequest(@PathVariable Integer requestId) throws MessagingException, UnsupportedEncodingException {
        deleteAccountRequestService.ejectDeleteRequest(requestId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
