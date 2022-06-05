package app.service;

import app.dto.ShipDTO;

public interface ShipService {
    void saveShip(ShipDTO shipDTO);
    void deleteShip(Integer shipId);
    ShipDTO updateShip(ShipDTO shipDTO);
    ShipDTO getShipById(Integer cottageId);
}
