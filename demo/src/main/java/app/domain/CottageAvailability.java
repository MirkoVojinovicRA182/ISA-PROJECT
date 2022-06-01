package app.domain;

import app.dto.CottageAvailabilityDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "startDate", unique = false, nullable = false)
    private LocalDate startDate;

    @Column(name = "endDate", unique = false, nullable = false)
    private LocalDate endDate;

    public CottageAvailability(){}

    public CottageAvailability(Integer id, Cottage cottage, LocalDate startDate, LocalDate endDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
