package app.repository;

import app.domain.CottageImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CottageImageRepository extends JpaRepository<CottageImage, Integer> {
}
