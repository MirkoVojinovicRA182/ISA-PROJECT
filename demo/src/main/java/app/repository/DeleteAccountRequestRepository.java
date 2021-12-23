package app.repository;

import app.domain.DeleteAccountRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeleteAccountRequestRepository extends JpaRepository<DeleteAccountRequest, Integer> {
}
