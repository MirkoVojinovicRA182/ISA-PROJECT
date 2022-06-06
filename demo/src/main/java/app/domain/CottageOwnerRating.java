package app.domain;

import javax.persistence.Entity;

@Entity
public class CottageOwnerRating extends OwnerRating {
    public CottageOwnerRating() {
    }

    public CottageOwnerRating(Integer rating, Integer reservationId, Integer ownerId, Integer clientId) {
        super(rating, reservationId, ownerId, clientId);
    }
}
