package app.repository;

import app.domain.Client;
import app.domain.CottageReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CottageReservationRepository extends JpaRepository<CottageReservation, Integer> {

    @Query("SELECT c.client FROM CottageReservation c WHERE c.cottage.cottageOwner.id = ?1")
    public List<Client> getAllUserEverReservated(Integer cottageOwnerId);

    @Query("SELECT c FROM CottageReservation c WHERE c.cottage.id = ?1")
    public List<CottageReservation> getForCottage(Integer cottageId);

    @Query("SELECT c FROM CottageReservation c WHERE c.cottage.id = ?1 AND c.endTime < ?2")
    public List<CottageReservation> getFinished(Integer cottageId, Date date);

}
