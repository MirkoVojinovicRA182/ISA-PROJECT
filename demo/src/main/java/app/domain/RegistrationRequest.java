package app.domain;

import app.domain.enums.UserType;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class RegistrationRequest{
    @Id
    @SequenceGenerator(name = "regReqSeqGen", sequenceName = "regReqSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regReqSeqGen")
    private Integer id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", unique = false, nullable = false)
    private String password;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "lastName", unique = false, nullable = false)
    private String lastName;

    @Column(name = "address", unique = false, nullable = false)
    private String address;

    @Column(name = "city", unique = false, nullable = false)
    private String city;

    @Column(name = "country", unique = false, nullable = false)
    private String country;

    @Column(name = "phoneNumber", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "userType", unique = false, nullable = false)
    private UserType userType;

    @Column(name = "registrationExplanation", unique = false, nullable = false)
    private String registrationExplanation;

    @Column(name = "requestDate", unique = false, nullable = false)
    private LocalDate requestDate;

    public RegistrationRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
