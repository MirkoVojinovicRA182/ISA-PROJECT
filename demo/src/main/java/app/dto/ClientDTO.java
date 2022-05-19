package app.dto;

import app.domain.Reservation;
import app.domain.enums.UserType;

import java.util.HashSet;
import java.util.Set;

public class ClientDTO {
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
    private UserType userType;
    private Set<Reservation> reservations = new HashSet<>();
    private String verificationCode;
    private UserType role;

    public ClientDTO(String email, String password, String name, String lastName, String address, String city,
                     String country, String phoneNumber, UserType userType, String verificationCode, UserType role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.verificationCode = verificationCode;
        this.role = role;
    }

    public ClientDTO(){}

    public UserType getRole() { return role; }

    public void setRole(UserType role) { this.role = role; }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public String getVerificationCode(){
        return this.verificationCode;
    }

}
