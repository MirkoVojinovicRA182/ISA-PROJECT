package app.repository;

import app.domain.InstructorAdventure;
import app.domain.Ship;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShipRepository extends JpaRepository<Ship, Integer> {
    @Query("SELECT u FROM Ship u WHERE u.id = ?1")
    Ship getByShipId(Integer id);
    
    @Query("SELECT u FROM Ship u where u.shipOwner.id = ?1")
    List<Ship> getUserShips(Integer userId);
}
