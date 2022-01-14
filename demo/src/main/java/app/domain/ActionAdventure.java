package app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ActionAdventure {

    @Id
    @SequenceGenerator(name = "aActionIdSeqGen", sequenceName = "aActionIdSeq", initialValue = 4, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aActionIdSeqGen")
    private Integer id;

    @Column(name = "creationDate")
    private LocalDateTime creationDate;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "additionalServices")
    private String additionalServices;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adventure_id")
    private InstructorAdventure adventure;

    public ActionAdventure() {
    }

    public ActionAdventure(LocalDateTime creationDate, LocalDateTime startTime, LocalDateTime endTime, Integer duration, String additionalServices, Double price, InstructorAdventure adventure) {
        this.creationDate = creationDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.additionalServices = additionalServices;
        this.price = price;
        this.adventure = adventure;
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

    public InstructorAdventure getAdventure() {
        return adventure;
    }

    public void setAdventure(InstructorAdventure adventure) {
        this.adventure = adventure;
    }
}
