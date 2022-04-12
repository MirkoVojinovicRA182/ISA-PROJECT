package app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StatsDateRangeDTO {
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private Integer userId;

    public StatsDateRangeDTO() {
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
