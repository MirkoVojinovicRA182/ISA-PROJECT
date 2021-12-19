package app.domain;

import app.domain.enums.UserType;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class RegistrationRequest extends ApplicationUser{

    @Column(name = "userType", unique = false, nullable = false)
    private UserType userType;

    @Column(name = "registrationExplanation", unique = false, nullable = false)
    private String registrationExplanation;

    @Column(name = "requestDate", unique = false, nullable = false)
    private LocalDate requestDate;

    public RegistrationRequest() {
    }

    public RegistrationRequest(UserType userType, String registrationExplanation, LocalDate requestDate) {
        this.userType = userType;
        this.registrationExplanation = registrationExplanation;
        this.requestDate = requestDate;
    }

    public UserType getUserType() { return userType; }

    public void setUserType(UserType userType) { this.userType = userType; }

    public String getRegistrationExplanation() { return registrationExplanation; }

    public void setRegistrationExplanation(String registrationExplanation) { this.registrationExplanation = registrationExplanation; }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
}
