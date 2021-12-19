package app.domain;

import app.domain.enums.UserType;
import jdk.jfr.Enabled;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Instructor extends ApplicationUser{

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<InstructorServiceProfile> services;
    public Instructor() {
    }
    public Instructor(String email, String password, String name, String lastName, String address, String city,
                      String country, String phoneNumber) {
        super(email, password, name, lastName, address, city, country, phoneNumber);
    }

    public Set<InstructorServiceProfile> getServices() {
        return services;
    }

    public void setProfile(Set<InstructorServiceProfile> services) {
        this.services = services;
    }
}
