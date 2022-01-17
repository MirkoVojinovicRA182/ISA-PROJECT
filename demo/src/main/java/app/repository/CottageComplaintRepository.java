package app.repository;

import app.domain.CottageComplaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CottageComplaintRepository extends JpaRepository<CottageComplaint, Integer> {
}
