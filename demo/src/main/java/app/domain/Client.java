package app.domain;

import app.domain.enums.UserType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client extends ApplicationUser{

    @Column(name = "verification_code", length = 64)
    private String verificationCode = "";

    @Column(name = "penals", unique = false, nullable = false)
    private Integer penals;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<AdventureReservation> adventureReservations = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<ShipReservation> shipReservations = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<CottageReservation> cottageReservations = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<CottageComplaint> cottageComplaints = new HashSet<CottageComplaint>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<InstructorComplaint> instructorComplaints = new HashSet<InstructorComplaint>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<ShipComplaint> shipComplaints = new HashSet<ShipComplaint>();

    public Client() {}

    public Client(String email, String password, String name, String lastName, String address,
                  String city, String country, String phoneNumber) {
        super(email, password, name, lastName, address, city, country, phoneNumber);
    }

    public Integer getPenals() {
        return penals;
    }

    public void setPenals(Integer penals) {
        this.penals = penals;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }


    public Set<AdventureReservation> getAdventureReservations() { return adventureReservations; }

    public Set<ShipReservation> getShipReservations() { return shipReservations; }

    public void setAdventureReservations(Set<AdventureReservation> adventureReservations) {
        this.adventureReservations = adventureReservations;
    }

    public void setShipReservations(Set<ShipReservation> shipReservations) {
        this.shipReservations = shipReservations;
    }

    public Set<CottageReservation> getCottageReservations() {
        return cottageReservations;
    }

    public void setCottageReservations(Set<CottageReservation> cottageReservations) {
        this.cottageReservations = cottageReservations;
    }

    public Set<CottageComplaint> getCottageComplaints() {
        return cottageComplaints;
    }

    public void setCottageComplaints(Set<CottageComplaint> cottageComplaints) {
        this.cottageComplaints = cottageComplaints;
    }

    public Set<InstructorComplaint> getInstructorComplaints() {
        return instructorComplaints;
    }

    public void setInstructorComplaints(Set<InstructorComplaint> instructorComplaints) {
        this.instructorComplaints = instructorComplaints;
    }

    public Set<ShipComplaint> getShipComplaints() {
        return shipComplaints;
    }

    public void setShipComplaints(Set<ShipComplaint> shipComplaints) {
        this.shipComplaints = shipComplaints;
    }
}
