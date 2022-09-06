package app.service;

import java.util.List;
import java.util.Set;

import app.dto.CottageImageDTO;
import app.dto.ShipDTO;

public interface ShipService {
    void saveShip(ShipDTO shipDTO);
    void deleteShip(Integer shipId);
    ShipDTO updateShip(ShipDTO shipDTO);
    ShipDTO getShipById(Integer cottageId);
    List<ShipDTO> getUserShips(Integer userId);
    ShipDTO addImage(Set<CottageImageDTO> img);
    ShipDTO removeImage(CottageImageDTO img);
}
