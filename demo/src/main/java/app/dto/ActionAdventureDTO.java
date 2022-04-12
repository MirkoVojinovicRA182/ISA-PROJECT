package app.dto;

import app.domain.ActionAdventure;

import java.time.LocalDateTime;

public class ActionAdventureDTO {
    private Integer id;
    private LocalDateTime creationDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer duration;
    private String additionalServices;
    private Double price;

    private Integer adventureId;

    public ActionAdventureDTO() {}

    public ActionAdventureDTO(ActionAdventure adventure){
        id = adventure.getId();
        creationDate = adventure.getCreationDate();
        startTime = adventure.getStartTime();
        endTime = adventure.getEndTime();
        duration = adventure.getDuration();
        additionalServices = adventure.getAdditionalServices();
        price = adventure.getPrice();

        adventureId = adventure.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(String additionalServices) {
        this.additionalServices = additionalServices;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAdventureId() {
        return adventureId;
    }

    public void setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
    }
}
