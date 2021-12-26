package app.domain;

import javax.persistence.Entity;

@Entity
public class Administrator extends ApplicationUser{
    public Administrator(String email, String password, String name, String lastName, String address, String city, String country, String phoneNumber) {
        super(email, password, name, lastName, address, city, country, phoneNumber);
    }
    public Administrator() {}
}
