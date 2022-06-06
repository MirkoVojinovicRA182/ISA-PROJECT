package app.repository;

import app.domain.AdventureRating;
import app.domain.CottageOwnerRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdventureRatingRepository extends JpaRepository<AdventureRating, Integer> {
}
