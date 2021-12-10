package app.domain;

import app.domain.enums.UserType;

public class Instructor extends User{

    public Instructor() {
    }

    public Instructor(Long id, String email, String password, String name, String lastName, String address, String city, String country, String phoneNumber, UserType userType) {
        super(id, email, password, name, lastName, address, city, country, phoneNumber, userType);
    }

    public Instructor(String email, String password, String name, String lastName, String address, String city, String country, String phoneNumber, UserType userType) {
        super(email, password, name, lastName, address, city, country, phoneNumber, userType);
    }

}
