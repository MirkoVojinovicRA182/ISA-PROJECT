package app.domain;

import javax.persistence.Entity;

@Entity
public class AdventureSubscription extends Subscription {
    public AdventureSubscription() {
    }

    public AdventureSubscription(Integer clientId, Integer subscribedTo) {
        super(clientId, subscribedTo);
    }
}
