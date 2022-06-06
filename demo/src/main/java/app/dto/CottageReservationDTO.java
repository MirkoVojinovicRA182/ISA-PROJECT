package app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

public class CottageReservationDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime endTime;

    private double price;
    private Integer clientId;
    private Integer cottageId;

    public CottageReservationDTO(){}

    public CottageReservationDTO(LocalDateTime startTime, LocalDateTime endTime,double price, Integer clientId, Integer cottageId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.clientId = clientId;
        this.cottageId = cottageId;
    }

    public CottageReservationDTO(LocalDateTime startTime, double price, Integer clientId, Integer cottageId) {
        this.startTime = startTime;
        this.endTime = startTime.plusDays(1);
        this.price = price;
        this.clientId = clientId;
        this.cottageId = cottageId;
    }

    public LocalDateTime getStartTime() { return startTime; }

    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public Integer getClientId() { return clientId; }

    public void setClientId(Integer clientId) { this.clientId = clientId; }

    public Integer getCottageId() { return cottageId; }

    public void setCottageId(Integer cottageId) { this.cottageId = cottageId; }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
