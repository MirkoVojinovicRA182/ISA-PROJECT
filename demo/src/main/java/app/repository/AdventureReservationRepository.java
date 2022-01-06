package app.repository;

import app.domain.AdventureReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdventureReservationRepository extends JpaRepository<AdventureReservation, Integer> {

    @Query("select reservation from AdventureReservation reservation join fetch reservation.adventure" +
            " adventure where adventure.instructor.id =?1")
    public List<AdventureReservation> getInstructorReservations(int instructorId);

}
