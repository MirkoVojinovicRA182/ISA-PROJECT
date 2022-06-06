package app.repository;

import app.domain.CottageOwnerRating;
import app.domain.CottageRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CottageRatingRepository extends JpaRepository<CottageRating, Integer> {
}
