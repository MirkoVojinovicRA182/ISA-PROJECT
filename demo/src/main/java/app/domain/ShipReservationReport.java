package app.domain;

import javax.persistence.*;

@Entity
public class ShipReservationReport {

    @Id
    @SequenceGenerator(name = "sRepSeqGen", sequenceName = "sRepSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sRepSeqGen")
    private Integer id;

    @Column(name = "reportText", unique = false, nullable = false)
    private String reportText;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reservation_id")
    private ShipReservation reservation;

    public ShipReservationReport(){}

    public ShipReservationReport(String reportText, ShipReservation reservation) {
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

    public ShipReservation getReservation() {
        return reservation;
    }

    public void setReservation(ShipReservation reservation) {
        this.reservation = reservation;
    }
}
