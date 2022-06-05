package app.service.impl;

import app.domain.Cottage;
import app.domain.Ship;
import app.domain.ShipOwner;
import app.dto.CottageDTO;
import app.dto.ShipDTO;
import app.repository.ShipOwnerRepository;
import app.repository.ShipRepository;
import app.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    private ShipOwnerRepository shipOwnerRepository;

    @Autowired
    private ShipRepository shipRepository;

    @Override
    public void saveShip(ShipDTO shipDTO) {
        Ship newShip = new Ship(shipDTO.getName(), shipDTO.getType(), shipDTO.getLength(), shipDTO.getEngineNumber(), shipDTO.getEnginePower(),
                shipDTO.getMaxSpeed(), shipDTO.getAddress(), shipDTO.getPromotiveDescription(), shipDTO.getCapacity(), shipDTO.getConductRules(),
                shipDTO.getPricelist(), shipDTO.getAdditionalServicesInfo(), shipDTO.getCancellationPolicy(), shipOwnerRepository.getById(shipDTO.getShipOwnerId()));
        shipRepository.save(newShip);
    }

    @Override
    public void deleteShip(Integer shipId) {
        shipRepository.deleteById(shipId);
    }

    @Override
    public ShipDTO updateShip(ShipDTO shipDTO) {
        Ship shipForUpdate = shipRepository.findById(shipDTO.getShipId()).orElseGet(null);
        shipForUpdate.update(shipDTO);
        shipRepository.save(shipForUpdate);
        return new ShipDTO(shipForUpdate);
    }

    @Override
    public ShipDTO getShipById(Integer shipId) {
        Ship ship = shipRepository.findById(shipId).orElseGet(null);
        if (ship == null) {
            return null;
        }
        return new ShipDTO(ship);
    }
}
