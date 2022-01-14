package app.repository;

import app.domain.AdventureReservation;
import app.domain.ShipReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipReservationRepository extends JpaRepository<ShipReservation, Integer> {}
