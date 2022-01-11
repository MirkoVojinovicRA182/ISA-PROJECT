package app.dto;

import app.domain.Client;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationSearchDTO {

    private LocalDate date;
    private Integer clientid;

    public ReservationSearchDTO(LocalDate date, Integer clientid) {
        this.date = date;
        this.clientid = clientid;
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
}
