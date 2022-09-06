package app.repository;

import app.domain.CottageAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CottageAvailabilityRepository extends JpaRepository<CottageAvailability, Integer> {
    @Query("SELECT c FROM CottageAvailability c WHERE c.cottage.id = ?1")
    List<CottageAvailability> findByCottageId(Integer id);
}
