package app.dto;


import app.domain.DeleteAccountRequest;
import app.domain.enums.UserType;

public class DeleteAccountRequestDTO {
    private Integer id;
    private String deleteReason;
    private Integer userId;

    public DeleteAccountRequestDTO() {
    }

    public DeleteAccountRequestDTO(DeleteAccountRequest account) {
        id = account.getId();
        deleteReason = account.getDeleteReason();
        userId = account.getUser().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
