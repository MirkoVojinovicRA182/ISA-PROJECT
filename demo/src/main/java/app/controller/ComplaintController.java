package app.controller;

import app.dto.ActionAdventureDTO;
import app.dto.ComplaintAnswerDTO;
import app.dto.InstructorComplaintDTO;
import app.dto.OwnerComplaintDTO;
import app.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @GetMapping(value = "/getInstructorComplaints")
    public ResponseEntity<List<InstructorComplaintDTO>> getInstructorComplaints() {
        return new ResponseEntity<List<InstructorComplaintDTO>>(complaintService.getInstructorComplaints(), HttpStatus.OK);
    }

    @GetMapping(value = "/getShipsComplaints")
    public ResponseEntity<List<OwnerComplaintDTO>> getShipsComplaints() {
        return new ResponseEntity<List<OwnerComplaintDTO>>(complaintService.getShipsComplaints(), HttpStatus.OK);
    }

    @GetMapping(value = "/getCottagesComplaints")
    public ResponseEntity<List<OwnerComplaintDTO>> getCottagesComplaints() {
        return new ResponseEntity<List<OwnerComplaintDTO>>(complaintService.getCottagesComplaints(), HttpStatus.OK);
    }

    @PostMapping(value = "/sendComplaintAnswer")
    public ResponseEntity<Void> sendComplaintAnswer(@RequestBody ComplaintAnswerDTO answer) throws MessagingException, UnsupportedEncodingException {
        complaintService.sendComplaintAnswer(answer);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
