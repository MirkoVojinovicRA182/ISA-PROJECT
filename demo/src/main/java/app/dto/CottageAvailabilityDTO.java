package app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CottageAvailabilityDTO {
    private Integer cottageAvailabilityId;
    private Integer cottageId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime endDate;

    public CottageAvailabilityDTO() {
    }

    public CottageAvailabilityDTO(Integer cottageAvailabilityId, Integer cottageId, LocalDateTime startDate, LocalDateTime endDate) {
        this.cottageAvailabilityId = cottageAvailabilityId;
        this.cottageId = cottageId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getCottageAvailabilityId() {
        return cottageAvailabilityId;
    }

    public void setCottageAvailabilityId(Integer cottageAvailabilityId) {
        this.cottageAvailabilityId = cottageAvailabilityId;
    }

    public Integer getCottageId() {
        return cottageId;
    }

    public void setCottageId(Integer cottageId) {
        this.cottageId = cottageId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
