package app.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Subscription {

    @Id
    @SequenceGenerator(name = "SubscriptionSeqGen", sequenceName = "SubscriptionSeq", initialValue = 5, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SubscriptionSeqGen")
    private Integer id;

    @Column(name = "client_id", unique = false, nullable = false)
    private Integer clientId;

    @Column(name = "subscribed_to", unique = false, nullable = false)
    private Integer subscribedTo;

    public Subscription(){}

    public Subscription(Integer clientId, Integer subscribedTo) {
        this.clientId = clientId;
        this.subscribedTo = subscribedTo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getSubscribedTo() {
        return subscribedTo;
    }

    public void setSubscribedTo(Integer subscribedTo) {
        this.subscribedTo = subscribedTo;
    }
}
