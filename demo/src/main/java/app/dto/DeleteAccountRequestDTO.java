package app.dto;


import app.domain.enums.UserType;

public class DeleteAccountRequestDTO {
    private String deleteReason;
    private Integer userId;
    private UserType userType;

    public DeleteAccountRequestDTO() {
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
