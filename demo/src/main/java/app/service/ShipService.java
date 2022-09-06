package app.service;

import java.util.List;
import java.util.Set;

import app.dto.CottageImageDTO;
import app.dto.ShipDTO;
import app.dto.ShipWithImagesDTO;

public interface ShipService {
    void saveShip(ShipDTO shipDTO);
    void deleteShip(Integer shipId);
    ShipWithImagesDTO updateShip(ShipDTO shipDTO);
    ShipDTO getShipById(Integer cottageId);
    List<ShipWithImagesDTO> getUserShips(Integer userId);
    ShipWithImagesDTO addImage(Set<CottageImageDTO> img);
    ShipWithImagesDTO removeImage(CottageImageDTO img);
}
