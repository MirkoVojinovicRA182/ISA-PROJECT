package app.repository;

import app.domain.CottageOwnerRating;
import app.domain.ShipRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRatingRepository extends JpaRepository<ShipRating, Integer> {
}
