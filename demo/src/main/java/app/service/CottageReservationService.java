package app.service;

import app.dto.CottageReservationDTO;
import app.dto.CottageReservationSearchDTO;

import java.util.List;

public interface CottageReservationService {
    List<CottageReservationDTO> getFreeCottages(CottageReservationSearchDTO dto);
    void bookACottage(CottageReservationDTO dto);
    CottageReservationDTO reserveCottage(CottageReservationDTO dto);
}
