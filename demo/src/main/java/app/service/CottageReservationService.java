package app.service;

import app.domain.Client;
import app.domain.CottageReservation;
import app.dto.*;

import java.util.Date;
import java.util.List;

public interface CottageReservationService {
    List<CottageReservationDTO> getFreeCottages(CottageReservationSearchDTO dto);
    void bookACottage(CottageReservationDTO dto);
    CottageReservationDTO reserveCottage(CottageReservationDTO dto);

    Boolean isCottageFree(ReservationDTO dto);

    CottageReservationDTO bookCottage(CottageReservationDTO dto);

    List<ReservationHistoryDTO> getHistoryReservations(Integer clientId);

    List<ReservationHistoryDTO> getCurrentReservations(Integer clientId);

    Boolean cancelCottageReservation(Integer id);
    List<CottageReservationDTO> getCottageReservations(Integer cottageId);
    List<UserProfileDTO> getAllUserEverReservated(Integer cottageOwnerId);

    ActionCottageDTO createActionCottage(ActionCottageDTO action);

    List<CottageReservationDTO> getFinished(Integer cottageId);

    List<CottageReservationDTO> getForCottage(Integer cottageId);
}
