package app.repository;

import app.domain.Organ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganRepository extends JpaRepository<Organ, Integer> {
}
