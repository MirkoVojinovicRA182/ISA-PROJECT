package app.service;

import app.domain.Cottage;
import app.domain.CottageReservation;
import app.domain.Ship;
import app.domain.ShipReservation;
import app.dto.CottageReservationDTO;
import app.dto.CottageReservationSearchDTO;
import app.dto.ShipReservationDTO;
import app.repository.ClientRepository;
import app.repository.CottageRepository;
import app.repository.CottageReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CottageReservationServiceImpl implements CottageReservationService{

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
            if(cottage.getRoomsNumber() >= dto.getRoomsNumber()){
                if(cottage.getBedsNumber() >= dto.getBedsNumber()) {
                    for (var reservation : reservations) {
                        if (reservation.getStartTime().equals(dateTime)) {
                            reserved = true;
                            break;
                        }
                    }
                    if (!reserved) {
                        freeReservations.add(new CottageReservationDTO(dateTime, cottage.getPricelist(),
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
        cottageReservationRepository.save(new CottageReservation(dto.getStartTime(), cottage.getPricelist(),
                clientRepository.getById(dto.getClientId()), cottage));
    }
}
