package app.domain;

import javax.persistence.*;

@Entity
public class Rating {
    @Id
    @SequenceGenerator(name = "ratingIdSeqGen", sequenceName = "ratingIdSeq", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ratingIdSeqGen")
    private Integer id;

    @Column(name = "client_id", unique = false, nullable = false)
    private Integer clientId;

    @Column(name = "entity_id", unique = false, nullable = false)
    private Integer entityId;

    @Column(name = "entity_rate", unique = false, nullable = false)
    private Integer entityRate;

    @Column(name = "is_rated", unique = false, nullable = false)
    private Boolean isRated;

    @Column(name = "owner_id", unique = false, nullable = false)
    private Integer ownerId;

    @Column(name = "owner_rate", unique = false, nullable = false)
    private Integer ownerRate;

    @Column(name = "reservation_id", unique = false, nullable = false)
    private Integer reservationId;

    @Column(name = "text", unique = false, nullable = false)
    private String text;

    public Rating() {
    }

    public Rating(Integer clientId, Integer entityId, Integer entityRate, Boolean isRated,
                  Integer ownerId, Integer ownerRate, Integer reservationId, String text) {
        this.clientId = clientId;
        this.entityId = entityId;
        this.entityRate = entityRate;
        this.isRated = isRated;
        this.ownerId = ownerId;
        this.ownerRate = ownerRate;
        this.reservationId = reservationId;
        this.text = text;
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
