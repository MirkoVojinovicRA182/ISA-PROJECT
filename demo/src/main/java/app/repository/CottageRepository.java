package app.repository;

import app.domain.Cottage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CottageRepository extends JpaRepository<Cottage, Integer> {

    @Query("SELECT u FROM Cottage u WHERE u.name LIKE %?2% AND u.cottageOwner.id = ?1")
    public Set<Cottage> searchCottage(Integer cottageOwnerId, String searchFilter);

    @Query("SELECT u FROM Cottage u WHERE u.cottageOwner.id = ?1")
    public Set<Cottage> getCottageOwnerCottages(Integer cottageOwnerId);
}
