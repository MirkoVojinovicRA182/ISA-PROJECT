package app.repository;

import app.domain.AdventureReservation;
import app.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.List;

public interface AdventureReservationRepository extends JpaRepository<AdventureReservation, Integer> {

    @Query("select reservation from AdventureReservation reservation join fetch reservation.adventure" +
            " adventure where adventure.instructor.id =?1")
    public List<AdventureReservation> getInstructorReservations(int instructorId);


    @Query("select reservation from AdventureReservation reservation join fetch reservation.adventure" +
            " adventure where adventure.instructor.id =?3 and reservation.endTime >=?1 and reservation.endTime <=?2")
    public List<AdventureReservation> getInstructorReservationsByDateRange(LocalDateTime fromDate,
                                                                           LocalDateTime toDate,
                                                                           Integer instructorId);

    public List<AdventureReservation> findByClientId(Integer clientId);

    public List<AdventureReservation> findByAdventureId(Integer adventureId);
}
