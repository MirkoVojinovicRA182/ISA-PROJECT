package app.domain;

import javax.persistence.Entity;

@Entity
public class InstructorRating extends OwnerRating{
    public InstructorRating() {
    }

    public InstructorRating(Integer rating, Integer reservationId, Integer ownerId, Integer clientId) {
        super(rating, reservationId, ownerId, clientId);
    }
}
