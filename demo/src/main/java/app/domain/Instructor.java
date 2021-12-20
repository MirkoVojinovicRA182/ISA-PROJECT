package app.domain;

import app.domain.enums.UserType;
import jdk.jfr.Enabled;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Instructor extends ApplicationUser{

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<InstructorAdventure> adventures = new HashSet<InstructorAdventure>();
    public Instructor() {
    }
    public Instructor(String email, String password, String name, String lastName, String address, String city,
                      String country, String phoneNumber) {
        super(email, password, name, lastName, address, city, country, phoneNumber);
    }

    public Set<InstructorAdventure> getAdventures() {
        return adventures;
    }

    public void setAdventures(Set<InstructorAdventure> adventures) {
        this.adventures = adventures;
    }

    public void addAdventure(InstructorAdventure adventure){
        adventures.add(adventure);
        adventure.setInstructor(this);
    }
}
