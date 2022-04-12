package app.service;

import app.dto.DeleteAccountRequestDTO;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface DeleteAccountRequestService {
    void createRequest(DeleteAccountRequestDTO dto);
    List<DeleteAccountRequestDTO> getRequests();
    void deleteAccount(DeleteAccountRequestDTO dto) throws MessagingException, UnsupportedEncodingException;

    void ejectDeleteRequest(Integer requestId) throws MessagingException, UnsupportedEncodingException;
}
