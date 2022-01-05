package app.dto;


import app.domain.DeleteAccountRequest;
import app.domain.enums.UserType;

public class DeleteAccountRequestDTO {
    private Integer id;
    private String deleteReason;
    private Integer userId;
    private String userFullName;
    private UserType userType;

    public DeleteAccountRequestDTO() {
    }

    public DeleteAccountRequestDTO(DeleteAccountRequest account) {
        id = account.getId();
        deleteReason = account.getDeleteReason();
        userId = account.getUser().getId();
        userFullName = account.getUserFullName();
        userType = account.getUserType();
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

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
