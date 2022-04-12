package app.dto;

import java.time.LocalDateTime;

public class ReservationStatisticsDTO {
    private String entityName;
    private LocalDateTime start;
    private LocalDateTime end;

    public ReservationStatisticsDTO() {
    }

    public ReservationStatisticsDTO(String entityName, LocalDateTime start, LocalDateTime end) {
        this.entityName = entityName;
        this.start = start;
        this.end = end;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
