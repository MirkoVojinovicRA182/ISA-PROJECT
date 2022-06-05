package app.dto;

public class SubscriptionDTO {
    private Integer id;
    private Integer clientId;
    private Integer subscribedTo;

    public SubscriptionDTO() {
    }

    public SubscriptionDTO(Integer id, Integer clientId, Integer subscribedTo) {
        this.id = id;
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

    public void setSubscribedTo(Integer subscribedToId) {
        this.subscribedTo = subscribedToId;
    }
}
