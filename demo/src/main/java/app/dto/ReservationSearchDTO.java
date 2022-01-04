package app.dto;

import app.domain.Client;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationSearchDTO {

    private LocalDate date;
    private Client client;

    public ReservationSearchDTO(LocalDate date, Client client) {
        this.date = date;
        this.client = client;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
