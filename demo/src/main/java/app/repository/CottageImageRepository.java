package app.repository;

import app.domain.CottageImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CottageImageRepository extends JpaRepository<CottageImage, Integer> {

    @Query("SELECT u FROM CottageImage u WHERE u.cottage.id = ?1")
    public Set<CottageImage> getByCottage(Integer cottageId);
}
