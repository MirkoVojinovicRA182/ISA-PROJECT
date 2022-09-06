package app.repository;

import app.domain.AdventureReservation;
import app.domain.Client;
import app.domain.CottageReservation;
import app.domain.ShipReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipReservationRepository extends JpaRepository<ShipReservation, Integer> {

    @Query("SELECT c.client FROM ShipReservation c WHERE c.ship.shipOwner.id = ?1")
    public List<Client> getAllUserEverReservated(Integer shipOwnerId);

    @Query("SELECT c FROM ShipReservation c WHERE c.ship.id = ?1")
    public List<ShipReservation> getForShip(Integer shipId);
}
