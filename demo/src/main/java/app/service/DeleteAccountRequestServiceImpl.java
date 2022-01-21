package app.service;

import app.domain.Administrator;
import app.domain.ApplicationUser;
import app.domain.DeleteAccountRequest;
import app.domain.Instructor;
import app.dto.DeleteAccountRequestDTO;
import app.repository.AdministratorRepository;
import app.repository.DeleteAccountRequestRepository;
import app.repository.InstructorRepository;
import app.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteAccountRequestServiceImpl implements DeleteAccountRequestService{

    @Autowired
    private DeleteAccountRequestRepository deleteAccountRequestRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public void createRequest(DeleteAccountRequestDTO dto) {
        ApplicationUser userForDelete = null;

        for(Instructor instructor: instructorRepository.findAll())
            if(instructor.getId().equals(dto.getUserId()))
                userForDelete = instructorRepository.findById(dto.getUserId()).orElseGet(null);

        for(Administrator administrator: administratorRepository.findAll())
            if(administrator.getId().equals(dto.getUserId()))
                userForDelete = administratorRepository.findById(dto.getUserId()).orElseGet(null);

        if(userForDelete != null)
            deleteAccountRequestRepository.save(new DeleteAccountRequest(dto.getDeleteReason(), userForDelete, dto.getUserFullName(), dto.getUserType()));
    }

    @Override
    public List<DeleteAccountRequestDTO> getRequests() {
        List<DeleteAccountRequestDTO> deleteAccountRequests = new ArrayList<DeleteAccountRequestDTO>();
        for(DeleteAccountRequest account: deleteAccountRequestRepository.findAll())
            deleteAccountRequests.add(new DeleteAccountRequestDTO(account));
        return deleteAccountRequests;
    }

    @Override
    public void deleteAccount(DeleteAccountRequestDTO dto) throws MessagingException, UnsupportedEncodingException {
        DeleteAccountRequest request = deleteAccountRequestRepository.findById(dto.getId()).orElseGet(null);
        deleteAccountRequestRepository.delete(request);

        for (Instructor instructor : instructorRepository.findAll())
            if (instructor.getId().equals(dto.getUserId()))
                instructorRepository.delete(instructor);

        Utility.sendMail("mail", "Account deletion approved", "Your account is deleted.");
    }

    @Override
    public void ejectDeleteRequest(Integer requestId) throws MessagingException, UnsupportedEncodingException {
        DeleteAccountRequest request = deleteAccountRequestRepository.findById(requestId).orElseGet(null);
        deleteAccountRequestRepository.delete(request);

        Utility.sendMail("mail", "Account deletion ejected", "Your request for deleting account is ejected.");
    }
}
