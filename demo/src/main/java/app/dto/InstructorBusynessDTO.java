package app.dto;

import app.domain.InstructorBusyness;

import java.time.LocalDateTime;

public class InstructorBusynessDTO {
    private Integer id;
    private LocalDateTime startInterval;
    private LocalDateTime endInterval;
    private Integer instructorId;

    public InstructorBusynessDTO() {
    }

    public InstructorBusynessDTO(InstructorBusyness instructorBusyness){
        id = instructorBusyness.getId();
        startInterval = instructorBusyness.getStartInterval();
        endInterval = instructorBusyness.getEndInterval();
        instructorId = instructorBusyness.getInstructor().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartInterval() {
        return startInterval;
    }

    public void setStartInterval(LocalDateTime startInterval) {
        this.startInterval = startInterval;
    }

    public LocalDateTime getEndInterval() {
        return endInterval;
    }

    public void setEndInterval(LocalDateTime endInterval) {
        this.endInterval = endInterval;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }
}
