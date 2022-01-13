package app.repository;

import app.domain.Instructor;
import app.domain.InstructorAdventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InstructorAdventureRepository extends JpaRepository<InstructorAdventure, Integer> {
    InstructorAdventure findByName(String name);
}
