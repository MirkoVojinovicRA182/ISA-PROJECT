package app.domain;

import javax.persistence.Entity;

@Entity
public class UserSubscription extends Subscription {
    public UserSubscription() {
    }

    public UserSubscription(Integer clientId, Integer subscribedTo) {
        super(clientId, subscribedTo);
    }
}
