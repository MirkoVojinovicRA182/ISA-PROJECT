package app.repository;

import app.domain.ShipOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipOwnerRepository extends JpaRepository<ShipOwner, Integer> {
}
