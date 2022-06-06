package app.service.impl;

import app.domain.*;
import app.dto.AdventureReservationDTO;
import app.dto.ReservationDTO;
import app.dto.ShipReservationDTO;
import app.dto.ShipReservationSearchDTO;
import app.repository.ClientRepository;
import app.repository.ShipRepository;
import app.repository.ShipReservationRepository;
import app.service.ShipReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShipReservationServiceImpl implements ShipReservationService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private ShipReservationRepository shipReservationRepository;

    @Override
    public List<ShipReservationDTO> getFreeShips(ShipReservationSearchDTO dto) {
        List<ShipReservationDTO> freeReservations = new ArrayList<>();


        return freeReservations;
    }

    @Override
    public void bookAShip(ShipReservationDTO dto) {

    }

    @Override
    public Boolean isShipFree(ReservationDTO dto) {
        if(dto.getStartTime().isAfter(dto.getEndTime()))
            return false;
        List<ShipReservation> reservations = shipReservationRepository.findAll();
        if (reservations.size() == 0)
            return true;

        for (ShipReservation res: reservations){
            if(res.getShip().getId() == dto.getId()){
                if(res.getStartTime().getYear() == dto.getStartTime().getYear()
                        && res.getStartTime().getDayOfMonth() == dto.getStartTime().getDayOfMonth()
                        && res.getStartTime().getMonth() == dto.getStartTime().getMonth()){
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public ShipReservationDTO bookShip(ShipReservationDTO dto) {
        Client client = clientRepository.getById(dto.getClientId());
        Ship ship = shipRepository.findById(dto.getShipId()).orElseGet(null);
        shipReservationRepository.save(new ShipReservation(dto, ship, client));

        return dto;
    }
}
