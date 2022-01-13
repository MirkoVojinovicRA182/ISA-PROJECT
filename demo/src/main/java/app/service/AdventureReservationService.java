package app.service;

import app.dto.AdventureReservationDTO;
import app.dto.AdventureReservationSearchDTO;

import java.util.List;

public interface AdventureReservationService{
    List<AdventureReservationDTO> getFreeAdventures(AdventureReservationSearchDTO dto);
    void bookAnInstructorAdventure(AdventureReservationDTO dto);
}
