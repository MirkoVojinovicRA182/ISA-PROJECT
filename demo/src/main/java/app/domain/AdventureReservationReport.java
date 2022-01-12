package app.domain;

import javax.persistence.*;

@Entity
public class AdventureReservationReport {
    @Id
    @SequenceGenerator(name = "aRepSeqGen", sequenceName = "aRepSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aRepSeqGen")
    private Integer id;

    @Column(name = "reportText", unique = false, nullable = false)
    private String reportText;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reservation_id")
    private AdventureReservation reservation;

    public AdventureReservationReport() {
    }

    public AdventureReservationReport(String reportText, AdventureReservation reservation) {
        this.reportText = reportText;
        this.reservation = reservation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public AdventureReservation getReservation() {
        return reservation;
    }

    public void setReservation(AdventureReservation reservation) {
        this.reservation = reservation;
    }
}
