package app.dto;


import app.domain.DeleteAccountRequest;
import app.domain.enums.UserType;

public class DeleteAccountRequestDTO {
    private String deleteReason;
    private Integer userId;

    public DeleteAccountRequestDTO() {
    }

    public DeleteAccountRequestDTO(DeleteAccountRequest account) {
        deleteReason = account.getDeleteReason();
        userId = account.getUser().getId();
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
