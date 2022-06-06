package app.service;

import app.dto.*;

import java.util.List;

public interface CottageReservationService {
    List<CottageReservationDTO> getFreeCottages(CottageReservationSearchDTO dto);
    void bookACottage(CottageReservationDTO dto);
    CottageReservationDTO reserveCottage(CottageReservationDTO dto);

    Boolean isCottageFree(ReservationDTO dto);

    CottageReservationDTO bookCottage(CottageReservationDTO dto);

    List<ReservationHistoryDTO> getHistoryReservations(Integer clientId);

    List<ReservationHistoryDTO> getCurrentReservations(Integer clientId);
}
