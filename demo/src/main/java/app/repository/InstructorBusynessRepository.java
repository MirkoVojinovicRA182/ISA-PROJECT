package app.repository;

import app.domain.InstructorBusyness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorBusynessRepository extends JpaRepository<InstructorBusyness, Integer> {
}
