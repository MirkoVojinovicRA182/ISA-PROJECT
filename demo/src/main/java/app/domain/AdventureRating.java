package app.domain;

import javax.persistence.*;

@Entity
public class AdventureRating {
    @Id
    @SequenceGenerator(name = "adventureRatingIdSeqGen", sequenceName = "adventureRatingIdSeq", initialValue = 5, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adventureRatingIdSeqGen")
    private Integer id;

    @Column(name = "rating", unique = false, nullable = false)
    private Integer rating;

    @Column(name = "reservation_id", unique = false, nullable = false)
    private Integer reservationId;

    @Column(name = "client_id", unique = false, nullable = false)
    private Integer clientId;

    AdventureRating() {
    }

    public AdventureRating(Integer id, Integer rating, Integer reservationId, Integer clientId) {
        this.id = id;
        this.rating = rating;
        this.reservationId = reservationId;
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

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
