package app.service;

import app.dto.CottageReservationDTO;
import app.dto.CottageReservationSearchDTO;
import app.dto.ReservationDTO;
import app.dto.ShipReservationDTO;

import java.util.List;

public interface CottageReservationService {
    List<CottageReservationDTO> getFreeCottages(CottageReservationSearchDTO dto);
    void bookACottage(CottageReservationDTO dto);
    CottageReservationDTO reserveCottage(CottageReservationDTO dto);

    Boolean isCottageFree(ReservationDTO dto);

    CottageReservationDTO bookCottage(CottageReservationDTO dto);
}
