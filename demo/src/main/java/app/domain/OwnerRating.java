package app.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class OwnerRating {
    @Id
    @SequenceGenerator(name = "ownerRatingIdSeqGen", sequenceName = "ownerRatingIdSeq", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ownerRatingIdSeqGen")
    private Integer id;

    @Column(name = "rating", unique = false, nullable = false)
    private Integer rating;

    @Column(name = "reservation_id", unique = false, nullable = false)
    private Integer reservationId;

    @Column(name = "owner_id", unique = false, nullable = false)
    private Integer ownerId;

    @Column(name = "client_id", unique = false, nullable = false)
    private Integer clientId;

    public OwnerRating() {
    }

    public OwnerRating(Integer id, Integer rating, Integer reservationId, Integer ownerId, Integer clientId) {
        this.id = id;
        this.rating = rating;
        this.reservationId = reservationId;
        this.ownerId = ownerId;
        this.clientId = clientId;
    }

    public OwnerRating(Integer rating, Integer reservationId, Integer ownerId, Integer clientId) {
        this.rating = rating;
        this.reservationId = reservationId;
        this.ownerId = ownerId;
        this.clientId = clientId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
