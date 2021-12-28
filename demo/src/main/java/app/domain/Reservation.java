package app.domain;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @SequenceGenerator(name = "reservationIdSeqGen", sequenceName = "reservationIdSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationIdSeqGen")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column
    private String name;

    public Reservation(){}

    public Reservation(String name, Client client) {
        this.name = name;
        this.client = client;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void SetId(Integer id) {
        this.id = id;
    }

    public Client getClient() { return client;}

    public void setClient(Client client) { this.client = client;}

    public void setId(Integer id) { this.id = id;}
}
