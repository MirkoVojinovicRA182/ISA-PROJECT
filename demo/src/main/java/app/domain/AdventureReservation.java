package app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AdventureReservation {
    @Id
    @SequenceGenerator(name = "adventureReservationIdSeqGen", sequenceName = "adventureReservationIdSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adventureReservationIdSeqGen")
    private Integer id;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "instructorAdventure_id")
    private InstructorAdventure instructorAdventure;

    public AdventureReservation(){}

    public AdventureReservation(LocalDateTime startTime, LocalDateTime endTime, Client client, InstructorAdventure instructorAdventure) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.instructorAdventure = instructorAdventure;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public InstructorAdventure getInstructorAdventure() {
        return instructorAdventure;
    }

    public void setInstructorAdventure(InstructorAdventure instructorAdventure) {
        this.instructorAdventure = instructorAdventure;
    }

    public Integer getId() {
        return id;
    }

    public void SetId(Integer id) {
        this.id = id;
    }

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

}
