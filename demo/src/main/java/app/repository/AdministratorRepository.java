package app.repository;

import app.domain.Administrator;
import app.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    Administrator findByEmail(String email);
}
