package app.repository;

import app.domain.ActionAdventure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionAdventureRepository extends JpaRepository<ActionAdventure, Integer> {
    List<ActionAdventure> getByAdventureId(Integer adventureId);
}
