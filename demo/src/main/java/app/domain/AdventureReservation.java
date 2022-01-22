package app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AdventureReservation {
    @Id
    @SequenceGenerator(name = "adventureReservationIdSeqGen", sequenceName = "adventureReservationIdSeq", initialValue = 16, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adventureReservationIdSeqGen")
    private Integer id;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private Double bill;

    @Column
    private Double systemSallary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adventure_id")
    private InstructorAdventure adventure;


    public AdventureReservation(){}

    public AdventureReservation(LocalDateTime startTime, LocalDateTime endTime, Client client, InstructorAdventure adventure, Double bill, Double systemSallary) {
        this.startTime = startTime;
        this.endTime = endTime.plusHours(1);
        this.client = client;
        this.adventure = adventure;
        this.bill = bill;
        this.systemSallary = systemSallary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public InstructorAdventure getAdventure() {
        return adventure;
    }

    public void setAdventure(InstructorAdventure adventure) {
        this.adventure = adventure;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    public Double getSystemSallary() {
        return systemSallary;
    }

    public void setSystemSallary(Double systemSallary) {
        this.systemSallary = systemSallary;
    }
}
