package app.service;

import app.dto.*;

import java.util.List;

public interface ShipReservationService {
    List<ShipReservationDTO> getFreeShips(ShipReservationSearchDTO dto);
    void bookAShip(ShipReservationDTO dto);

    Boolean isShipFree(ReservationDTO dto);

    ShipReservationDTO bookShip(ShipReservationDTO dto);

    List<ReservationHistoryDTO> getShipHistoryReservations(Integer clientId);

    List<ReservationHistoryDTO> getShipCurrentReservations(Integer clientId);

    boolean cancelShipReservation(Integer id);

    List<UserProfileDTO> getAllUserEverReservated(Integer shipOwnerId);

    List<ShipReservationDTO> getForShip(Integer shipId);
}
