package app.dto;

import app.domain.Client;
import app.domain.InstructorAdventure;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class AdventureReservationDTO {

    private Integer clientId;
    private Integer instructorAdventureId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String price;

    public AdventureReservationDTO(){}

    public AdventureReservationDTO(Integer clientId, Integer instructorAdventureId,
                                   LocalDateTime startTime, LocalDateTime endTime, String price) {
        this.clientId = clientId;
        this.instructorAdventureId = instructorAdventureId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClient(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getInstructorAdventureId() {
        return instructorAdventureId;
    }

    public void setInstructorAdventure(Integer instructorAdventureId) {
        this.instructorAdventureId = instructorAdventureId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }
}
