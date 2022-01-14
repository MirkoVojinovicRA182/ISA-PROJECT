package app.service;

import app.dto.ShipReservationDTO;
import app.dto.ShipReservationSearchDTO;

import java.util.List;

public interface ShipReservationService {
    List<ShipReservationDTO> getFreeShips(ShipReservationSearchDTO dto);
    void bookAShip(ShipReservationDTO dto);
}
