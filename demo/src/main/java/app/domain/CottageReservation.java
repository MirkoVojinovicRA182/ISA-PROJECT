package app.domain;

import app.dto.CottageReservationDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CottageReservation {
    @Id
    @SequenceGenerator(name = "cottageReservationIdSeqGen", sequenceName = "cottageReservationIdSeq", initialValue = 5, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cottageReservationIdSeqGen")
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @Column
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @Column
    private LocalDateTime endTime;

    @Column
    private Integer price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cottage_id")
    @JsonBackReference(value = "cottage_reservations")
    private Cottage cottage;

    public CottageReservation(){}

    public CottageReservation(LocalDateTime startTime, LocalDateTime endTime,Integer price, Client client, Cottage cottage) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.client = client;
        this.cottage = cottage;
    }

    public CottageReservation(LocalDateTime startTime, Integer price, Client client, Cottage cottage) {
        this.startTime = startTime;
        this.endTime = startTime.plusDays(1);
        this.price = price;
        this.client = client;
        this.cottage = cottage;
    }

    public CottageReservation(CottageReservationDTO dto, Cottage cottage, Client client) {
        this.startTime = dto.getStartTime();
        this.endTime = dto.getEndTime();
        this.price = dto.getPrice();
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

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    public Cottage getCottage() { return cottage; }

    public void setCottage(Cottage cottage) { this.cottage = cottage; }
}
