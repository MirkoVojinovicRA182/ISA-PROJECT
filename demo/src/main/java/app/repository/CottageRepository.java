package app.repository;

import app.domain.Cottage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CottageRepository extends JpaRepository<Cottage, Integer> {

    @Query("SELECT u FROM Cottage u WHERE u.name LIKE %?1%")
    public Cottage searchCottage(String searchFilter);

}
