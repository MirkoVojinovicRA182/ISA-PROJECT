package app.dto;

import app.domain.AdventureReservation;
import app.domain.Client;
import app.domain.InstructorAdventure;
import app.service.AdventureReservationService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Date;

public class AdventureReservationDTO {
    private Integer id;
    private Integer clientId;
    private Integer adventureId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime endTime;

    public AdventureReservationDTO(){}
    
    private Integer price;


    public AdventureReservationDTO(AdventureReservation adventureReservation){
        id = adventureReservation.getId();
        clientId = adventureReservation.getClient().getId();
        adventureId = adventureReservation.getAdventure().getId();
        startTime = adventureReservation.getStartTime();
        endTime = adventureReservation.getEndTime();
        price = adventureReservation.getPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getAdventureId() {
        return adventureId;
    }

    public void setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
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

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }
}
