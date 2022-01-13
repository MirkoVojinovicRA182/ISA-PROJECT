package app.dto;

import java.time.LocalDate;

public class AdventureReservationSearchDTO {

    private LocalDate date;
    private Integer clientid;
    private Integer maxCountOfParticipants;
    private Integer hours;

    public AdventureReservationSearchDTO(LocalDate date, Integer clientid, Integer maxCountOfParticipants, Integer hours) {
        this.date = date;
        this.clientid = clientid;
        this.maxCountOfParticipants = maxCountOfParticipants;
        this.hours = hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getClientId() {
        return clientid;
    }

    public void setClientId(Integer clientid) {
        this.clientid = clientid;
    }

    public Integer getMaxCountOfParticipants() { return maxCountOfParticipants; }

    public void setMaxCountOfParticipants(Integer maxCountOfParticipants) {
        this.maxCountOfParticipants = maxCountOfParticipants;
    }

    public Integer getHours() { return hours; }

    public void setHours(Integer hours) { this.hours = hours; }
}
