package app.service;

import app.domain.ShipComplaint;
import app.dto.ComplaintAnswerDTO;
import app.dto.InstructorComplaintDTO;
import app.dto.OwnerComplaintDTO;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ComplaintService {
    List<InstructorComplaintDTO> getInstructorComplaints();

    List<OwnerComplaintDTO> getShipsComplaints();

    List<OwnerComplaintDTO> getCottagesComplaints();

    void sendComplaintAnswer(ComplaintAnswerDTO answer) throws MessagingException, UnsupportedEncodingException;

}
