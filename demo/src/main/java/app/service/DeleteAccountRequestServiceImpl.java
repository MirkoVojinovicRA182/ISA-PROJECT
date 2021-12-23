package app.service;

import app.domain.ApplicationUser;
import app.domain.DeleteAccountRequest;
import app.domain.Instructor;
import app.dto.DeleteAccountRequestDTO;
import app.repository.DeleteAccountRequestRepository;
import app.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteAccountRequestServiceImpl implements DeleteAccountRequestService{

    @Autowired
    private DeleteAccountRequestRepository deleteAccountRequestRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public void createRequest(DeleteAccountRequestDTO dto) {
        ApplicationUser userForDelete = new Instructor();

        for(Instructor instructor: instructorRepository.findAll())
            if(instructor.getId().equals(dto.getUserId()))
                userForDelete = instructorRepository.findById(dto.getUserId()).orElseGet(null);

        deleteAccountRequestRepository.save(new DeleteAccountRequest(dto.getDeleteReason(), userForDelete));
    }

    @Override
    public List<DeleteAccountRequestDTO> getRequests() {
        List<DeleteAccountRequestDTO> deleteAccountRequests = new ArrayList<DeleteAccountRequestDTO>();
        for(DeleteAccountRequest account: deleteAccountRequestRepository.findAll())
            deleteAccountRequests.add(new DeleteAccountRequestDTO(account));
        return deleteAccountRequests;
    }

    @Override
    public void deleteAccount(DeleteAccountRequestDTO dto) {
        DeleteAccountRequest request = deleteAccountRequestRepository.findById(dto.getId()).orElseGet(null);
        deleteAccountRequestRepository.delete(request);
        
        for (Instructor instructor : instructorRepository.findAll())
            if (instructor.getId().equals(dto.getUserId()))
                instructorRepository.delete(instructor);
    }
}
