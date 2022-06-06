package app.domain;

import javax.persistence.Entity;

@Entity
public class ShipOwnerRating extends OwnerRating {
    public ShipOwnerRating() {
    }

    public ShipOwnerRating(Integer rating, Integer reservationId, Integer ownerId, Integer clientId) {
        super(rating, reservationId, ownerId, clientId);
    }
}
