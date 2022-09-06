package app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ShipAvailabilityDTO {

    private Integer shipAvailabilityId;
    private Integer shipId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime endDate;

    public ShipAvailabilityDTO(){super();}

    public ShipAvailabilityDTO(Integer shipAvailabilityId, Integer shipId, LocalDateTime startDate, LocalDateTime endDate) {
        this.shipAvailabilityId = shipAvailabilityId;
        this.shipId = shipId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getShipAvailabilityId() {
        return shipAvailabilityId;
    }

    public void setShipAvailabilityId(Integer shipAvailabilityId) {
        this.shipAvailabilityId = shipAvailabilityId;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
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
