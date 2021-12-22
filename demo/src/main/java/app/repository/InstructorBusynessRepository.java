package app.repository;

import app.domain.InstructorBusyness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorBusynessRepository extends JpaRepository<InstructorBusyness, Integer> {
    List<InstructorBusyness> findByInstructorId(Integer instructorId);
}
