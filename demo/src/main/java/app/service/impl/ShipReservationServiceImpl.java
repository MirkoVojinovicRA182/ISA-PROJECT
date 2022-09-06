package app.service.impl;

import app.domain.*;
import app.dto.*;
import app.repository.ClientRepository;
import app.repository.ShipOwnerRepository;
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

    @Autowired
    private ShipOwnerRepository shipOwnerRepository;

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

    @Override
    public List<ReservationHistoryDTO> getShipHistoryReservations(Integer clientId) {
        List<ShipReservation> reservations = shipReservationRepository.findAll();
        List<ReservationHistoryDTO> historyReservations = new ArrayList<>();
        for (ShipReservation res : reservations) {
            if (res.getClient().getId() == clientId && res.getStartTime().isBefore(LocalDateTime.now())) {
                ShipOwner shipOwner = shipOwnerRepository.findById(res.getShip().getShipOwner().getId()).orElseGet(null);
                historyReservations.add(new ReservationHistoryDTO(res.getId(), res.getShip().getId(), shipOwner.getId(), res.getShip().getName(),
                        res.getShip().getAddress(), res.getPrice(), false, res.getStartTime()));
            }
        }

        return historyReservations;
    }

    @Override
    public List<ReservationHistoryDTO> getShipCurrentReservations(Integer clientId) {
        List<ShipReservation> reservations = shipReservationRepository.findAll();
        List<ReservationHistoryDTO> currentReservations = new ArrayList<>();
        for (ShipReservation res : reservations) {
            if (res.getClient().getId() == clientId
                    && (res.getStartTime().isAfter(LocalDateTime.now())
                    || (res.getStartTime().getYear() == LocalDateTime.now().getYear()
                    && res.getStartTime().getDayOfMonth() == LocalDateTime.now().getDayOfMonth()
                    && res.getStartTime().getMonth() == LocalDateTime.now().getMonth()))) {
                ShipOwner shipOwner = shipOwnerRepository.findById(res.getShip().getShipOwner().getId()).orElseGet(null);
                currentReservations.add(new ReservationHistoryDTO(res.getId(), res.getShip().getId(), shipOwner.getId(), res.getShip().getName(),
                        res.getShip().getAddress(), res.getPrice(), false, res.getStartTime()));
            }
        }

        return currentReservations;
    }

    @Override
    public boolean cancelShipReservation(Integer id) {
        shipReservationRepository.deleteById(id);
        return true;
    }
    @Override
    public List<UserProfileDTO> getAllUserEverReservated(Integer cottageOwnerId){
        List<UserProfileDTO> users = new ArrayList<>();
        List<Client> clients = shipReservationRepository.getAllUserEverReservated(cottageOwnerId);
        for (Client client : clients){
            users.add(new UserProfileDTO(client));
        }
        return users;
    }

    @Override
    public List<ShipReservationDTO> getForShip(Integer shipId){
        List<ShipReservation> reservations =  shipReservationRepository.getForShip(shipId);
        List<ShipReservationDTO> dtos = new ArrayList<>();
        for (ShipReservation res : reservations){
            ShipReservationDTO dto = new ShipReservationDTO(res.getStartTime(), res.getPrice(),
                    res.getClient().getId(),  res.getShip().getId());
            dto.setId(res.getId());
            dtos.add(dto);
        }
        return dtos;
    }
}
