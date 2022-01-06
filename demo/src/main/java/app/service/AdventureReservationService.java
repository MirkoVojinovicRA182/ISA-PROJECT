package app.service;

import app.dto.AdventureReservationDTO;
import app.dto.ReservationSearchDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface AdventureReservationService{
    List<AdventureReservationDTO> getFreeAdventures(ReservationSearchDTO dto);
    void bookAnInstructorAdventure(AdventureReservationDTO dto);
    List<AdventureReservationDTO> getInstructorReservations(int instructorId);
}
