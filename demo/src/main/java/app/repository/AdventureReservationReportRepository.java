package app.repository;

import app.domain.AdventureReservationReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdventureReservationReportRepository extends JpaRepository<AdventureReservationReport, Integer> {
}
