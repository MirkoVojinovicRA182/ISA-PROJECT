package app.domain;

import app.domain.enums.UserType;

public class Instructor extends User{
    private InstructorServiceProfile profile;
    public Instructor() {
    }

    public Instructor(Long id, String email, String password, String name, String lastName, String address, String city,
                      String country, String phoneNumber, UserType userType, InstructorServiceProfile profile) {
        super(id, email, password, name, lastName, address, city, country, phoneNumber, userType);
        this.profile = profile;
    }

    public Instructor(String email, String password, String name, String lastName, String address, String city,
                      String country, String phoneNumber, UserType userType, InstructorServiceProfile profile) {
        super(email, password, name, lastName, address, city, country, phoneNumber, userType);
        this.profile = profile;
    }

}
