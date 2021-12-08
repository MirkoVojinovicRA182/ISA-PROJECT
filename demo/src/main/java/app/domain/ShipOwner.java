package app.domain;

import app.domain.enums.UserType;

public class ShipOwner extends User{
    private String registrationExplanation;

    public ShipOwner() {
    }

    public ShipOwner(Long id, String email, String password, String name, String lastName, String address, String city, String country, String phoneNumber, UserType userType, String registrationExplanation) {
        super(id, email, password, name, lastName, address, city, country, phoneNumber, userType);
        this.registrationExplanation = registrationExplanation;
    }

    public ShipOwner(String email, String password, String name, String lastName, String address, String city, String country, String phoneNumber, UserType userType, String registrationExplanation) {
        super(email, password, name, lastName, address, city, country, phoneNumber, userType);
        this.registrationExplanation = registrationExplanation;
    }

    public String getRegistrationExplanation() {
        return registrationExplanation;
    }

    public void setRegistrationExplanation(String registrationExplanation) {
        this.registrationExplanation = registrationExplanation;
    }
}
