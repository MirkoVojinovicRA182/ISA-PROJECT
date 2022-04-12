package app.repository;

import app.domain.ShipComplaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipComplaintRepository extends JpaRepository<ShipComplaint, Integer> {
}
