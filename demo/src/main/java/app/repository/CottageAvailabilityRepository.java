package app.repository;

import app.domain.CottageAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CottageAvailabilityRepository extends JpaRepository<CottageAvailability, Integer> {
    CottageAvailability findByCottageId(Integer id);
}
