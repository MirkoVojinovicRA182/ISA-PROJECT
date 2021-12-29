package app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client extends ApplicationUser{

    @Column(name = "verification_code", length = 64)
    private String verificationCode = "";

    private boolean enabled = false;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Reservation> reservations = new HashSet<Reservation>();

    public Client() {}

    public Client(String email, String password, String name, String lastName, String address,
                  String city, String country, String phoneNumber) {
        super(email, password, name, lastName, address, city, country, phoneNumber);
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
