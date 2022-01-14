package app.service;

import app.domain.*;
import app.dto.AdventureReservationDTO;
import app.dto.ShipReservationDTO;
import app.dto.ShipReservationSearchDTO;
import app.repository.ClientRepository;
import app.repository.ShipRepository;
import app.repository.ShipReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShipReservationServiceImpl implements ShipReservationService{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private ShipReservationRepository shipReservationRepository;

    @Override
    public List<ShipReservationDTO> getFreeShips(ShipReservationSearchDTO dto) {
        List<ShipReservationDTO> freeReservations = new ArrayList<>();
        List<ShipReservation> reservations = shipReservationRepository.findAll();
        List<Ship> ships = shipRepository.findAll();
        LocalDateTime dateTime = dto.getDate().atTime(0,0,0);
        boolean reserved = false;

        for(Ship ship : ships){
            reserved = false;
            if(ship.getCapacity() >= dto.getCapacity()){
                for(var reservation : reservations) {
                    if (reservation.getStartTime().equals(dateTime)) {
                        reserved = true;
                        break;
                    }
                }
                if (!reserved) {
                    freeReservations.add(new ShipReservationDTO(dateTime, ship.getPricelist(),
                            dto.getClientId(), ship.getId()));
                }
            }
        }

        return freeReservations;
    }

    @Override
    public void bookAShip(ShipReservationDTO dto) {
        Ship ship = shipRepository.getByShipId(dto.getShipId());
        shipReservationRepository.save(new ShipReservation(dto.getStartTime(), ship.getPricelist(),
                clientRepository.getById(dto.getClientId()), ship));
    }
}
