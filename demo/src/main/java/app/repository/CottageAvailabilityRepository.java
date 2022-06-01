package app.repository;

import app.domain.CottageAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CottageAvailabilityRepository extends JpaRepository<CottageAvailability, Integer> {
}
