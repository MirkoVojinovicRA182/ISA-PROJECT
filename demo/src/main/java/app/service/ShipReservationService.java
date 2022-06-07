package app.service;

import app.dto.ReservationDTO;
import app.dto.ReservationHistoryDTO;
import app.dto.ShipReservationDTO;
import app.dto.ShipReservationSearchDTO;

import java.util.List;

public interface ShipReservationService {
    List<ShipReservationDTO> getFreeShips(ShipReservationSearchDTO dto);
    void bookAShip(ShipReservationDTO dto);

    Boolean isShipFree(ReservationDTO dto);

    ShipReservationDTO bookShip(ShipReservationDTO dto);

    List<ReservationHistoryDTO> getShipHistoryReservations(Integer clientId);

    List<ReservationHistoryDTO> getShipCurrentReservations(Integer clientId);

    boolean cancelShipReservation(Integer id);
}
