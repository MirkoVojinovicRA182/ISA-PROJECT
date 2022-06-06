package app.repository;

import app.domain.ShipOwnerRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipOwnerRatingRepository extends JpaRepository<ShipOwnerRating, Integer> {
}
