package app.dto;

import app.domain.CottageOwner;

import javax.persistence.Column;

public class CottageOwnerDTO {
    private Integer cottageOwnerId;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;

    public CottageOwnerDTO(){
        super();
    }

    public CottageOwnerDTO(Integer cottageOwnerId, String email, String password, String name, String lastName, String address, String city, String country, String phoneNumber){
        this.cottageOwnerId = cottageOwnerId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public CottageOwnerDTO(CottageOwner cottageOwner){
        this.cottageOwnerId  = cottageOwner.getId();
        this.email = cottageOwner.getEmail();
        this.password = cottageOwner.getPassword();
        this.name = cottageOwner.getName();
        this.lastName = cottageOwner.getLastName();
        this.address = cottageOwner.getAddress();
        this.city = cottageOwner.getCity();
        this.country = cottageOwner.getCountry();
        this.phoneNumber = cottageOwner.getPhoneNumber();
    }

    public Integer getCottageOwnerId() {
        return cottageOwnerId;
    }

    public void setCottageOwnerId(Integer cottageOwnerId) {
        this.cottageOwnerId = cottageOwnerId;
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
}
