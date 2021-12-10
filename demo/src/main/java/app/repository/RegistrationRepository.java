package app.repository;

import app.domain.*;
import org.springframework.stereotype.Repository;
import app.domain.enums.UserType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class RegistrationRepository {
    private static AtomicLong counter = new AtomicLong();

    private final List<RegistrationRequest> requests = new ArrayList<RegistrationRequest>();
    private final List<CottageOwner> cottageOwners = new ArrayList<CottageOwner>();
    private final List<ShipOwner> shipOwners = new ArrayList<ShipOwner>();
    private final List<Instructor> instructors = new ArrayList<Instructor>();


    public Collection<RegistrationRequest> findAll() {
        return this.requests;
    }

    public RegistrationRequest createRegistrationRequest(RegistrationRequest request) {
        requests.add(request);
        return request;
    }
    public User registerUser(User user){
        UserType type = user.getUserType();
        if(type.equals(UserType.CottageOwner)) {
            CottageOwner cottageOwner = new CottageOwner(user.getEmail(), user.getPassword(), user.getName(),
                    user.getLastName(), user.getAddress(), user.getCity(), user.getCountry(), user.getPhoneNumber(), user.getUserType());
            cottageOwners.add(cottageOwner);
            return cottageOwner;
        }
        else if(type.equals(UserType.ShipOwner)) {
            ShipOwner shipOwner = new ShipOwner(user.getEmail(), user.getPassword(), user.getName(),
                    user.getLastName(), user.getAddress(), user.getCity(), user.getCountry(), user.getPhoneNumber(), user.getUserType());
            shipOwners.add(shipOwner);
            return shipOwner;
        }
        else if(type.equals(UserType.Instructor)) {
            Instructor instructor = new Instructor(user.getEmail(), user.getPassword(), user.getName(),
                    user.getLastName(), user.getAddress(), user.getCity(), user.getCountry(), user.getPhoneNumber(), user.getUserType(), new InstructorServiceProfile());
            instructors.add(instructor);
            return instructor;
        }
        return null;
    }
}
