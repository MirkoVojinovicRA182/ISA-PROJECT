package app.dto;

public class ShipReservationReportDTO {

    private String reportText;
    private Integer reservationId;

    public ShipReservationReportDTO(){}

    public ShipReservationReportDTO(String reportText, Integer reservationId) {
        this.reportText = reportText;
        this.reservationId = reservationId;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }
}
