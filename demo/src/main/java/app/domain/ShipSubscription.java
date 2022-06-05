package app.domain;

import javax.persistence.Entity;

@Entity
public class ShipSubscription extends Subscription {
    public ShipSubscription() {
    }

    public ShipSubscription(Integer clientId, Integer subscribedTo) {
        super(clientId, subscribedTo);
    }
}
