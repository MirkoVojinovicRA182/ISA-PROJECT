package app.service;

import java.util.List;
import java.util.Set;

import app.dto.*;

public interface ShipService {
    void saveShip(ShipDTO shipDTO);
    void deleteShip(Integer shipId);
    ShipWithImagesDTO updateShip(ShipDTO shipDTO);
    ShipDTO getShipById(Integer cottageId);
    List<ShipWithImagesDTO> getUserShips(Integer userId);
    ShipWithImagesDTO addImage(Set<CottageImageDTO> img);
    ShipWithImagesDTO removeImage(CottageImageDTO img);

    ShipWithImagesDTO addShipAvailability(Set<ShipAvailabilityDTO> availability);
    ShipReservationReportDTO createReport(ShipReservationReportDTO dto);
}
