package app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AdventureReservation {
    @Id
    @SequenceGenerator(name = "adventureReservationIdSeqGen", sequenceName = "adventureReservationIdSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adventureReservationIdSeqGen")
    private Integer id;

    @Column
    private Integer clientId;

    @Column
    private Integer instructorAdventureId;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    public AdventureReservation(){}

    public AdventureReservation(Integer instructorAdventureId, Integer clientId,
                                LocalDateTime startTime, LocalDateTime endTime) {
        this.instructorAdventureId = instructorAdventureId;
        this.clientId = clientId;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public Integer getId() {
        return id;
    }

    public void SetId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() { return clientId;}

    public void setClientId(Integer clientId) { this.clientId = clientId;}

    public void setId(Integer id) { this.id = id;}

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

    public Integer getInstructorAdventureId() {
        return instructorAdventureId;
    }
}
