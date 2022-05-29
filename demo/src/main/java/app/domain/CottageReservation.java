package app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CottageReservation {
    @Id
    @SequenceGenerator(name = "cottageReservationIdSeqGen", sequenceName = "cottageReservationIdSeq", initialValue = 5, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cottageReservationIdSeqGen")
    private Integer id;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private String price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cottage_id")
    @JsonBackReference
    private Cottage cottage;

    public CottageReservation(){}

    public CottageReservation(LocalDateTime startTime, LocalDateTime endTime,String price, Client client, Cottage cottage) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.client = client;
        this.cottage = cottage;
    }

    public CottageReservation(LocalDateTime startTime, String price, Client client, Cottage cottage) {
        this.startTime = startTime;
        this.endTime = startTime.plusDays(1);
        this.price = price;
        this.client = client;
        this.cottage = cottage;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getStartTime() { return startTime; }

    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    public Cottage getCottage() { return cottage; }

    public void setCottage(Cottage cottage) { this.cottage = cottage; }
}
