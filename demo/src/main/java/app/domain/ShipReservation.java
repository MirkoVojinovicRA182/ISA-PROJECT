package app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ShipReservation {

    @Id
    @SequenceGenerator(name = "shipReservationIdSeqGen", sequenceName = "shipReservationIdSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipReservationIdSeqGen")
    private Integer id;

    @Column
    private LocalDateTime startTime;

    @Column
    private String price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ship_id")
    private Ship ship;

    public ShipReservation(){}

    public ShipReservation(LocalDateTime startTime, String price, Client client, Ship ship) {
        this.startTime = startTime;
        this.price = price;
        this.client = client;
        this.ship = ship;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getStartTime() { return startTime; }

    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    public Ship getShip() { return ship; }

    public void setShip(Ship ship) { this.ship = ship; }
}
