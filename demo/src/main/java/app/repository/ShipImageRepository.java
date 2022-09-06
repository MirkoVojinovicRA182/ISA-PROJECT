package app.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.domain.ShipImage;

public interface ShipImageRepository extends JpaRepository<ShipImage, Integer> {

	@Query("SELECT u FROM ShipImage u WHERE u.ship.id = ?1")
    public Set<ShipImage> getByShip(Integer shipId);
	
}
