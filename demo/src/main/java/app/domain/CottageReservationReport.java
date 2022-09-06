package app.domain;

import javax.persistence.*;

@Entity
public class CottageReservationReport {
    @Id
    @SequenceGenerator(name = "cRepSeqGen", sequenceName = "cRepSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cRepSeqGen")
    private Integer id;

    @Column(name = "reportText", unique = false, nullable = false)
    private String reportText;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reservation_id")
    private CottageReservation reservation;

    public CottageReservationReport(){}

    public CottageReservationReport(String reportText, CottageReservation reservation) {
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

    public CottageReservation getReservation() {
        return reservation;
    }

    public void setReservation(CottageReservation reservation) {
        this.reservation = reservation;
    }
}
