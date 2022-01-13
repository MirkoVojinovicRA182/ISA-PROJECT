package app.repository;

import app.domain.AdventureReservation;
import app.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface AdventureReservationRepository extends JpaRepository<AdventureReservation, Integer> {}
