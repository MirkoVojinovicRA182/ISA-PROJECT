package app.domain;

import app.domain.enums.UserType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ShipOwner extends ApplicationUser{

    public ShipOwner() {
    }

    public ShipOwner(Integer id, String email, String password, String name, String lastName,
                     String address, String city, String country, String phoneNumber) {
        super(id, email, password, name, lastName, address, city, country, phoneNumber);
    }

    public ShipOwner(String email, String password, String name, String lastName,
                     String address, String city, String country, String phoneNumber) {
        super(email, password, name, lastName, address, city, country, phoneNumber);
    }
}
