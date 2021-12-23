package app.service;

import app.dto.DeleteAccountRequestDTO;

import java.util.List;

public interface DeleteAccountRequestService {
    void createRequest(DeleteAccountRequestDTO dto);
    List<DeleteAccountRequestDTO> getRequests();
    void deleteAccount(DeleteAccountRequestDTO dto);

    void ejectDeleteRequest(Integer requestId);
}
