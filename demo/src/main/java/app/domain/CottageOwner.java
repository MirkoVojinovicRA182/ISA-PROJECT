package app.domain;

import app.domain.enums.UserType;
import app.dto.CottageOwnerDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
public class CottageOwner extends ApplicationUser{

    @OneToMany(mappedBy = "cottageOwner", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Cottage> cottages = new HashSet<Cottage>();

    @OneToMany(mappedBy = "cottageOwner", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<CottageComplaint> complaints = new HashSet<CottageComplaint>();

    public CottageOwner() {
    }

    public CottageOwner(Integer id, String email, String password, String name, String lastName,
                        String address, String city, String country, String phoneNumber) {
        super(id, email, password, name, lastName, address, city, country, phoneNumber);
    }

    public CottageOwner(String email, String password, String name, String lastName,
                        String address, String city, String country, String phoneNumber) {
        super(email, password, name, lastName, address, city, country, phoneNumber);

    }

    public CottageOwner(String email, String password, String name, String lastName,
                        String address, String city, String country, String phoneNumber, boolean enabled) {
        super(email, password, name, lastName, address, city, country, phoneNumber, enabled);

    }

    public Set<Cottage> getCottages() {
        return cottages;
    }

    public void setCottages(Set<Cottage> cottages) {
        this.cottages = cottages;
    }

    public void update(CottageOwnerDTO cottageOwnerDTO) {
        setName(cottageOwnerDTO.getName());
        setAddress(cottageOwnerDTO.getAddress());
        setCity(cottageOwnerDTO.getCity());
        setCountry(cottageOwnerDTO.getCountry());
        setLastName(cottageOwnerDTO.getLastName());
        setPhoneNumber(cottageOwnerDTO.getPhoneNumber());
        setEmail(cottageOwnerDTO.getEmail());
        setPassword(cottageOwnerDTO.getPassword());
    }
}
