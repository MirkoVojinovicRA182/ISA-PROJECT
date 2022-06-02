package app.service.impl;

import app.domain.*;
import app.dto.CottageReservationDTO;
import app.dto.CottageReservationSearchDTO;
import app.dto.ShipReservationDTO;
import app.repository.ClientRepository;
import app.repository.CottageRepository;
import app.repository.CottageReservationRepository;
import app.service.CottageReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CottageReservationServiceImpl implements CottageReservationService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CottageReservationRepository cottageReservationRepository;

    @Autowired
    private CottageRepository cottageRepository;

    @Override
    public List<CottageReservationDTO> getFreeCottages(CottageReservationSearchDTO dto) {
        List<CottageReservationDTO> freeReservations = new ArrayList<>();
        List<CottageReservation> reservations = cottageReservationRepository.findAll();
        List<Cottage> cottages = cottageRepository.findAll();
        LocalDateTime dateTime = dto.getDate().atTime(0,0,0);
        boolean reserved = false;

        for(Cottage cottage : cottages){
            reserved = false;
            if(cottage.getRooms().size() >= dto.getRoomsNumber()){
                if(cottage.getBedsNumber() >= dto.getBedsNumber()) {
                    for (var reservation : reservations) {
                        if (reservation.getStartTime().equals(dateTime)) {
                            reserved = true;
                            break;
                        }
                    }
                    if (!reserved) {
                        freeReservations.add(new CottageReservationDTO(dateTime,100,
                                dto.getClientId(), cottage.getId()));
                    }
                }
            }
        }

        return freeReservations;
    }

    @Override
    public void bookACottage(CottageReservationDTO dto) {
        Cottage cottage = cottageRepository.getByCottageId(dto.getCottageId());
        cottageReservationRepository.save(new CottageReservation(dto.getStartTime(), dto.getPrice(),
                clientRepository.getById(dto.getClientId()), cottage));
    }

    @Override
    public CottageReservationDTO reserveCottage(CottageReservationDTO dto) {
        Cottage cottageForUpdate = cottageRepository.getById(dto.getCottageId());
        Client clientForUpdate = clientRepository.getById(dto.getClientId());
        CottageReservation reservation = new CottageReservation(dto, cottageForUpdate, clientForUpdate);
        cottageForUpdate.getCottageReservations().add(reservation);
        cottageReservationRepository.save(reservation);
        cottageRepository.save(cottageForUpdate);
        clientRepository.save(clientForUpdate);
        return dto;
    }
}
