package app.domain;

import app.domain.enums.UserType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShipOwner extends ApplicationUser{

    @OneToMany(mappedBy = "shipOwner", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Ship> ships = new HashSet<Ship>();

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
