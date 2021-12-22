package app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class InstructorBusyness {
    @Id
    @SequenceGenerator(name = "instructorBusynessIdSeqGen", sequenceName = "instructorBusynessIdSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructorBusynessIdSeqGen")
    private Integer id;

    @Column(name = "startInterval", unique = true, nullable = false)
    private LocalDateTime startInterval;

    @Column(name = "endInterval", unique = true, nullable = false)
    private LocalDateTime endInterval;

    @ManyToOne()
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public InstructorBusyness(LocalDateTime startInterval, LocalDateTime endInterval, Instructor instructor) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.instructor = instructor;
    }

    public InstructorBusyness() {
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
