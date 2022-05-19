package app.service.impl;

import app.domain.CottageComplaint;
import app.domain.InstructorComplaint;
import app.domain.Ship;
import app.domain.ShipComplaint;
import app.dto.ComplaintAnswerDTO;
import app.dto.InstructorComplaintDTO;
import app.dto.OwnerComplaintDTO;
import app.repository.CottageComplaintRepository;
import app.repository.InstructorComplaintRepository;
import app.repository.ShipComplaintRepository;
import app.service.ComplaintService;
import app.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private InstructorComplaintRepository instructorComplaintRepository;

    @Autowired
    private ShipComplaintRepository shipComplaintRepository;

    @Autowired
    private CottageComplaintRepository cottageComplaintRepository;

    @Override
    public List<InstructorComplaintDTO> getInstructorComplaints() {
        List<InstructorComplaintDTO> instructorComplaintDTOS = new ArrayList<InstructorComplaintDTO>();

        for(InstructorComplaint complaint: instructorComplaintRepository.findAll())
            instructorComplaintDTOS.add(new InstructorComplaintDTO(complaint));

        return instructorComplaintDTOS;
    }

    @Override
    public List<OwnerComplaintDTO> getShipsComplaints() {
        List<OwnerComplaintDTO> complaints = new ArrayList<OwnerComplaintDTO>();

        for(ShipComplaint complaint: shipComplaintRepository.findAll()) {
            OwnerComplaintDTO complaintDTO = new OwnerComplaintDTO(complaint.getShipOwner().getName() + " " + complaint.getShipOwner().getLastName(),
                    complaint.getShipOwner().getEmail(),
                    complaint.getShip().getName(),
                    complaint.getClient().getName() + " " + complaint.getClient().getLastName(),
                    complaint.getClient().getEmail(),
                    complaint.getText());
            complaints.add(complaintDTO);
        }

        return complaints;
    }

    @Override
    public List<OwnerComplaintDTO> getCottagesComplaints() {
        List<OwnerComplaintDTO> complaints = new ArrayList<OwnerComplaintDTO>();

        for(CottageComplaint complaint: cottageComplaintRepository.findAll()) {
            OwnerComplaintDTO complaintDTO = new OwnerComplaintDTO(complaint.getCottageOwner().getName() + " " + complaint.getCottageOwner().getLastName(),
                    complaint.getCottageOwner().getEmail(),
                    complaint.getCottage().getName(),
                    complaint.getClient().getName() + " " + complaint.getClient().getLastName(),
                    complaint.getClient().getEmail(),
                    complaint.getText());
            complaints.add(complaintDTO);
        }

        return complaints;
    }

    @Override
    public void sendComplaintAnswer(ComplaintAnswerDTO answer) throws MessagingException, UnsupportedEncodingException {
        Utility.sendMail(answer.getClientEmail(), "Complaint answer", answer.getAnswerText());
        Utility.sendMail(answer.getServiceProviderEmail(), "Complaint answer", answer.getAnswerText());
    }
}
