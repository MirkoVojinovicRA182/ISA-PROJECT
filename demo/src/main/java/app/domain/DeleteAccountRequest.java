package app.domain;

import javax.persistence.*;

@Entity
public class DeleteAccountRequest {

    @Id
    @SequenceGenerator(name = "deleteReqSeqGen", sequenceName = "deleteReqSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deleteReqSeqGen")
    private Integer id;

    @Column(name = "deleteReason", unique = false, nullable = false)
    private String deleteReason;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    public DeleteAccountRequest() {
    }

    public DeleteAccountRequest(String deleteReason, ApplicationUser user) {
        this.deleteReason = deleteReason;
        this.user = user;
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
}
