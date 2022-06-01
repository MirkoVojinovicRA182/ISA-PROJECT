package app.dto;

import app.domain.enums.UserType;

// DTO koji preuzima podatke iz HTML forme za registraciju
public class UserRequest {

    private Integer id;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
    private String userType;

    public UserRequest(){}

    public UserRequest(Integer id, String email, String name, String lastName, String address, String city,
                       String country, String phoneNumber, String userType) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }

    public String getName() { return name; }

    public void setFirstName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getUserType() { return userType; }

    public void setUserType(String userType) { this.userType = userType; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}

