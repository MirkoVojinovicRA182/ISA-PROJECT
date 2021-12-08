package app.domain;

import app.domain.enums.UserType;

public class Instructor extends User{
    private UserType userType;
    private String registrationExplanation;

    public Instructor() {
    }

    public Instructor(Long id, String email, String password, String name, String lastName, String adress, String city, String country, String phoneNumber, UserType userType, String registrationExplanation) {
        super(id, email, password, name, lastName, adress, city, country, phoneNumber);
        this.userType = userType;
        this.registrationExplanation = registrationExplanation;
    }

    public Instructor(String email, String password, String name, String lastName, String adress, String city, String country, String phoneNumber, UserType userType, String registrationExplanation) {
        super(email, password, name, lastName, adress, city, country, phoneNumber);
        this.userType = userType;
        this.registrationExplanation = registrationExplanation;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getRegistrationExplanation() {
        return registrationExplanation;
    }

    public void setRegistrationExplanation(String registrationExplanation) {
        this.registrationExplanation = registrationExplanation;
    }
}
