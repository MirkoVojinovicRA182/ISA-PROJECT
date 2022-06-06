package app.dto;

import app.domain.Client;
import app.domain.Ship;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class ShipReservationDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime startTime;

    private Integer price;
    private Integer clientId;
    private Integer shipId;

    public ShipReservationDTO(){}

    public ShipReservationDTO(LocalDateTime startTime, Integer price, Integer clientId, Integer shipId) {
        this.startTime = startTime;
        this.price = price;
        this.clientId = clientId;
        this.shipId = shipId;
    }

    public LocalDateTime getStartTime() { return startTime; }

    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }

    public Integer getClientId() { return clientId; }

    public void setClientId(Integer clientId) { this.clientId = clientId; }

    public Integer getShipId() { return shipId; }

    public void setShipId(Integer shipId) { this.shipId = shipId; }
}
