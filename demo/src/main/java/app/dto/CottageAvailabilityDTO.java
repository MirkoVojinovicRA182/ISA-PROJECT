package app.dto;

import java.time.LocalDate;

public class CottageAvailabilityDTO {
    private Integer cottageAvailabilityId;
    private Integer cottageId;
    private LocalDate startDate;
    private LocalDate endDate;

    public CottageAvailabilityDTO() {
    }

    public CottageAvailabilityDTO(Integer cottageAvailabilityId, Integer cottageId, LocalDate startDate, LocalDate endDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
