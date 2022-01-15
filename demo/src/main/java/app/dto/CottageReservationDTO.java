package app.dto;

import java.time.LocalDateTime;

public class CottageReservationDTO {
    private LocalDateTime startTime;
    private String price;
    private Integer clientId;
    private Integer cottageId;

    public CottageReservationDTO(){}

    public CottageReservationDTO(LocalDateTime startTime, String price, Integer clientId, Integer cottageId) {
        this.startTime = startTime;
        this.price = price;
        this.clientId = clientId;
        this.cottageId = cottageId;
    }

    public LocalDateTime getStartTime() { return startTime; }

    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public Integer getClientId() { return clientId; }

    public void setClientId(Integer clientId) { this.clientId = clientId; }

    public Integer getCottageId() { return cottageId; }

    public void setCottageId(Integer cottageId) { this.cottageId = cottageId; }
}
