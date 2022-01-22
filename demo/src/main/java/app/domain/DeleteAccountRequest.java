package app.domain;

import app.domain.enums.UserType;

import javax.persistence.*;

@Entity
public class DeleteAccountRequest {

    @Id
    @SequenceGenerator(name = "deleteReqSeqGen", sequenceName = "deleteReqSeq", initialValue = 3, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deleteReqSeqGen")
    private Integer id;

    @Column(name = "deleteReason", unique = false, nullable = false)
    private String deleteReason;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    @Column(name = "userFullName", unique = false, nullable = false)
    private String userFullName;

    @Column(name = "userType", unique = false, nullable = false)
    private UserType userType;

    public DeleteAccountRequest() {
    }

    public DeleteAccountRequest(String deleteReason, ApplicationUser user, String userFullName, UserType userType) {
        this.deleteReason = deleteReason;
        this.user = user;
        this.userFullName = userFullName;
        this.userType = userType;
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

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
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
