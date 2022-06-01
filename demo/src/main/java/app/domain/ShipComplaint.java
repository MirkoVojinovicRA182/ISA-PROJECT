package app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ShipComplaint {
    @Id
    @SequenceGenerator(name = "sComplIdSeqGen", sequenceName = "sComplIdSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sComplIdSeqGen")
    private Integer id;

    @Column
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ship_owner_id")
    private ShipOwner shipOwner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    public ShipComplaint() {
    }

    public ShipComplaint(String text, Ship ship, ShipOwner shipOwner, Client client) {
        this.text = text;
        this.ship = ship;
        this.shipOwner = shipOwner;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public ShipOwner getShipOwner() {
        return shipOwner;
    }

    public void setShipOwner(ShipOwner shipOwner) {
        this.shipOwner = shipOwner;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
