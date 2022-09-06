package app.domain;

import app.dto.CottageAvailabilityDTO;
import app.dto.ShipAvailabilityDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ShipAvailability {

    @Id
    @SequenceGenerator(name = "shipAvailabilitySeqGen", sequenceName = "shipAvailabilitySeq", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipAvailabilitySeqGen")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ship_id")
    @JsonBackReference(value = "ship_ship_availability")
    private Ship ship;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @Column(name = "startDate", unique = false, nullable = false)
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @Column(name = "endDate", unique = false, nullable = false)
    private LocalDateTime endDate;

    public ShipAvailability(){}

    public ShipAvailability(Integer id, Ship ship, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.ship = ship;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ShipAvailability(ShipAvailabilityDTO dto) {
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
