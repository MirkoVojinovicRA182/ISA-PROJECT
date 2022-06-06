package app.dto;

public class RatingDTO {
    private Integer clientId;
    private Integer entityId;
    private Integer entityRate;
    private Boolean isRated;
    private Integer ownerId;
    private Integer ownerRate;
    private Integer reservationId;
    private String text;

    public RatingDTO() {
    }

    public RatingDTO(Integer clientId, Integer entityId, Integer entityRate, Boolean isRated, Integer ownerId, Integer ownerRate, Integer reservationId, String text) {
        this.clientId = clientId;
        this.entityId = entityId;
        this.entityRate = entityRate;
        this.isRated = isRated;
        this.ownerId = ownerId;
        this.ownerRate = ownerRate;
        this.reservationId = reservationId;
        this.text = text;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getEntityRate() {
        return entityRate;
    }

    public void setEntityRate(Integer entityRate) {
        this.entityRate = entityRate;
    }

    public Boolean getRated() {
        return isRated;
    }

    public void setRated(Boolean rated) {
        isRated = rated;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getOwnerRate() {
        return ownerRate;
    }

    public void setOwnerRate(Integer ownerRate) {
        this.ownerRate = ownerRate;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
