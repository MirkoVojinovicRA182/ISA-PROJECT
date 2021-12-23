package app.service;

import app.domain.ApplicationUser;
import app.domain.DeleteAccountRequest;
import app.domain.Instructor;
import app.domain.enums.UserType;
import app.dto.DeleteAccountRequestDTO;
import app.repository.DeleteAccountRequestRepository;
import app.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountRequestServiceImpl implements DeleteAccountRequestService{

    @Autowired
    private DeleteAccountRequestRepository deleteAccountRequestRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public void createRequest(DeleteAccountRequestDTO dto) {
        UserType userType = dto.getUserType();
        ApplicationUser userForDelete = new Instructor();
        if(userType.equals(UserType.Instructor))
            userForDelete = instructorRepository.findById(dto.getUserId()).orElseGet(null);
        deleteAccountRequestRepository.save(new DeleteAccountRequest(dto.getDeleteReason(), userForDelete));
    }
}
