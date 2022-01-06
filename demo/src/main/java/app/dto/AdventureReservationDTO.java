package app.dto;

import app.domain.AdventureReservation;
import app.domain.Client;
import app.domain.InstructorAdventure;
import app.service.AdventureReservationService;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class AdventureReservationDTO {
    private Integer id;
    private String clientUsername;
    private String adventureName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public AdventureReservationDTO(){}


    public AdventureReservationDTO(AdventureReservation adventureReservation){
        id = adventureReservation.getId();
        clientUsername = adventureReservation.getClient().getEmail();
        adventureName = adventureReservation.getAdventure().getName();
        startTime = adventureReservation.getStartTime();
        endTime = adventureReservation.getEndTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getAdventureName() {
        return adventureName;
    }

    public void setAdventureName(String adventureName) {
        this.adventureName = adventureName;
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
}
