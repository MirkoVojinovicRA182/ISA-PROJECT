package app.repository;

import app.domain.Client;
import app.domain.CottageOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT u FROM Client u WHERE u.verificationCode = ?1")
    Client findByVerificationCode(String code);

    @Query("SELECT u FROM Client u WHERE u.email = ?1")
    Client findByEmail(String email);
}
