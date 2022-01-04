package app.repository;

import app.domain.AdventureReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdventureReservationRepository extends JpaRepository<AdventureReservation, Integer> {}
