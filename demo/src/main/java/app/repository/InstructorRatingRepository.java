package app.repository;

import app.domain.InstructorRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRatingRepository extends JpaRepository<InstructorRating, Integer> {
}
