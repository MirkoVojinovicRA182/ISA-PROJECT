package app.repository;

import app.domain.InstructorComplaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorComplaintRepository extends JpaRepository<InstructorComplaint, Integer> {
}
