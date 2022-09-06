package app.repository;

import app.domain.CottageReservationReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CottageReservationReportRepository extends JpaRepository<CottageReservationReport, Integer> {
}
