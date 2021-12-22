package app.dto;

import app.domain.ApplicationUser;
import app.domain.enums.UserType;

public class UserProfileDTO {

    private Integer userId;
    private String name;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
    private UserType userType;

    public UserProfileDTO() {
    }

    public UserProfileDTO(ApplicationUser applicationUser) {
        name = applicationUser.getName();
        lastName = applicationUser.getLastName();
        address = applicationUser.getAddress();
        city = applicationUser.getCity();
        country = applicationUser.getCountry();
        phoneNumber = applicationUser.getPhoneNumber();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
