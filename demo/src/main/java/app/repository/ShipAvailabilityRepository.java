package app.repository;

import app.domain.CottageAvailability;
import app.domain.ShipAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipAvailabilityRepository extends JpaRepository<ShipAvailability, Integer> {

    @Query("SELECT c FROM ShipAvailability c WHERE c.ship.id = ?1")
    List<ShipAvailability> findByShipId(Integer id);
}
