package app.service;

import app.dto.ReservationDTO;
import app.dto.ShipReservationDTO;
import app.dto.ShipReservationSearchDTO;

import java.util.List;

public interface ShipReservationService {
    List<ShipReservationDTO> getFreeShips(ShipReservationSearchDTO dto);
    void bookAShip(ShipReservationDTO dto);

    Boolean isShipFree(ReservationDTO dto);

    ShipReservationDTO bookShip(ShipReservationDTO dto);
}
