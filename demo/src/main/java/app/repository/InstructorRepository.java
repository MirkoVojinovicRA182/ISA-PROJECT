package app.repository;

import app.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

    @Query("select i from Instructor i join fetch i.adventures a where i.id = ?1")
    public Instructor findOneWithAdventures(Integer instructorId);
}
