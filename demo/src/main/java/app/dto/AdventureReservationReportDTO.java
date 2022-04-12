package app.dto;

import app.domain.AdventureReservationReport;

public class AdventureReservationReportDTO {
    private String reportText;
    private Integer reservationId;

    public AdventureReservationReportDTO() {
    }

    public AdventureReservationReportDTO(AdventureReservationReport adventureReservationReport){
        reportText = adventureReservationReport.getReportText();
        reservationId = adventureReservationReport.getReservation().getId();
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
