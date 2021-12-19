package app.repository;

import app.domain.CottageOwner;
import app.domain.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Integer> {
}
