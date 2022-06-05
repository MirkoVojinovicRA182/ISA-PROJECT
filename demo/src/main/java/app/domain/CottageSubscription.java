package app.domain;

import javax.persistence.Entity;

@Entity
public class CottageSubscription extends Subscription {
    public CottageSubscription() {
    }

    public CottageSubscription(Integer clientId, Integer subscribedTo) {
        super(clientId, subscribedTo);
    }
}
