package app.repository;

import app.domain.Body;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyRepository extends JpaRepository<Body, Integer> {
}
