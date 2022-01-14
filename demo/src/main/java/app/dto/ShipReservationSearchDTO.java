package app.dto;

import java.time.LocalDate;

public class ShipReservationSearchDTO {

    private LocalDate date;
    private Integer clientId;
    private Integer capacity;

    public ShipReservationSearchDTO(){}

    public ShipReservationSearchDTO(LocalDate date, Integer clientId, Integer capacity) {
        this.date = date;
        this.clientId = clientId;
        this.capacity = capacity;
    }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public Integer getClientId() { return clientId; }

    public void setClientId(Integer clientId) { this.clientId = clientId; }

    public Integer getCapacity() { return capacity; }

    public void setCapacity(Integer capacity) { this.capacity = capacity; }
}
