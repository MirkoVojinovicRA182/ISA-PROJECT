package app.repository;

import app.domain.Client;
import app.domain.Instructor;
import app.domain.InstructorAdventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InstructorAdventureRepository extends JpaRepository<InstructorAdventure, Integer> {
    @Query("SELECT u FROM InstructorAdventure u WHERE u.id = ?1")
    InstructorAdventure getByAdventureId(Integer id);
}
