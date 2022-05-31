package app.repository;

import app.domain.CottageOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Integer> {
    @Query("SELECT u FROM CottageOwner u WHERE u.email = ?1")
    CottageOwner findByEmail(String username);
}
