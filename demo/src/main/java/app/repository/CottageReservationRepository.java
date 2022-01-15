package app.repository;

import app.domain.CottageReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CottageReservationRepository extends JpaRepository<CottageReservation, Integer> {
}
