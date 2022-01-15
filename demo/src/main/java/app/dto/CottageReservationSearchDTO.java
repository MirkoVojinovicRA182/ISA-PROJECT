package app.dto;

import java.time.LocalDate;

public class CottageReservationSearchDTO {
    private LocalDate date;
    private Integer clientId;
    private int roomsNumber;
    private int bedsNumber;

    public CottageReservationSearchDTO(){}

    public CottageReservationSearchDTO(LocalDate date, Integer clientId, int roomsNumber, int bedsNumber) {
        this.date = date;
        this.clientId = clientId;
        this.roomsNumber = roomsNumber;
        this.bedsNumber = bedsNumber;
    }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public Integer getClientId() { return clientId; }

    public void setClientId(Integer clientId) { this.clientId = clientId; }

    public int getRoomsNumber() { return roomsNumber; }

    public void setRoomsNumber(int roomsNumber) { this.roomsNumber = roomsNumber; }

    public int getBedsNumber() { return bedsNumber; }

    public void setBedsNumber(int bedsNumber) { this.bedsNumber = bedsNumber; }
}
