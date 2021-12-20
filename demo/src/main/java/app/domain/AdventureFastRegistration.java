package app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AdventureFastRegistration {
    @Id
    @SequenceGenerator(name = "adventureFastRegistrationIdSeqGen", sequenceName = "adventureFastRegistrationIdSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adventureFastRegistrationIdSeqGen")
    private Integer id;

    @Column(name = "startTime", unique = false, nullable = false)
    private LocalDateTime startTime;

    @Column(name = "duration", unique = false, nullable = false)
    private double duration;
    //private List<String> additionalServices;
    @Column(name = "startValidityTime", unique = false, nullable = false)
    private LocalDateTime startValidityTime;

    @Column(name = "endValidityTime", unique = false, nullable = false)
    private LocalDateTime endValidityTime;

    @Column(name = "discount", unique = false, nullable = false)
    private double discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructorAdventure_id")
    private InstructorAdventure instructorAdventure;

    public AdventureFastRegistration() {
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    /*public List<String> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<String> additionalServices) {
        this.additionalServices = additionalServices;
    }*/

    public LocalDateTime getStartValidityTime() {
        return startValidityTime;
    }

    public void setStartValidityTime(LocalDateTime startValidityTime) {
        this.startValidityTime = startValidityTime;
    }

    public LocalDateTime getEndValidityTime() {
        return endValidityTime;
    }

    public void setEndValidityTime(LocalDateTime endValidityTime) {
        this.endValidityTime = endValidityTime;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public InstructorAdventure getInstructorServiceProfile() {
        return instructorAdventure;
    }

    public void setInstructorAdventureProfile(InstructorAdventure instructorAdventure) {
        this.instructorAdventure = instructorAdventure;
    }
}
