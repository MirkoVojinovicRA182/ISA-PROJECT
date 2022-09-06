package app.repository;

import app.domain.CottageReservationReport;
import app.domain.ShipReservationReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipReservationReportRepository extends JpaRepository<ShipReservationReport, Integer> {
}
