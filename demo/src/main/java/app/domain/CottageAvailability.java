package app.domain;

import app.dto.CottageAvailabilityDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CottageAvailability {
    @Id
    @SequenceGenerator(name = "cottageAvailabilitySeqGen", sequenceName = "cottageAvailabilitySeq", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cottageAvailabilitySeqGen")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cottage_id")
    @JsonBackReference(value = "cottage_cottage_availability")
    private Cottage cottage;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @Column(name = "startDate", unique = false, nullable = false)
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @Column(name = "endDate", unique = false, nullable = false)
    private LocalDateTime endDate;

    public CottageAvailability(){}

    public CottageAvailability(Integer id, Cottage cottage, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.cottage = cottage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CottageAvailability(CottageAvailabilityDTO dto) {
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cottage getCottage() {
        return cottage;
    }

    public void setCottage(Cottage cottage) {
        this.cottage = cottage;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
