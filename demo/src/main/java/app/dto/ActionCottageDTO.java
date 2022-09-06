package app.dto;

import app.domain.ActionCottage;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ActionCottageDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime creationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime endTime;

    private Integer duration;

    private Integer price;

    private Integer cottageId;

    public ActionCottageDTO(){}

    public ActionCottageDTO(LocalDateTime creationDate, LocalDateTime startTime, LocalDateTime endTime, Integer duration, Integer price, Integer cottageId) {
        this.creationDate = creationDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.price = price;
        this.cottageId = cottageId;
    }

    public ActionCottageDTO(ActionCottage actionCottage){
        this.creationDate = actionCottage.getCreationDate();
        this.startTime = actionCottage.getStartTime();
        this.endTime = actionCottage.getEndTime();
        this.duration = actionCottage.getDuration();
        this.price = actionCottage.getPrice();
        this.cottageId = actionCottage.getId();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCottageId() {
        return cottageId;
    }
}
