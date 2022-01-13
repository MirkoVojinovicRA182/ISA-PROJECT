package app.service;

import app.domain.*;
import app.dto.AdventureReservationDTO;
import app.dto.AdventureReservationReportDTO;
import app.dto.ReservationSearchDTO;
import app.repository.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class AdventureReservationServiceImpl implements AdventureReservationService{

    @Autowired
    private AdventureReservationRepository adventureReservationRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdventureReservationReportRepository adventureReservationReportRepository;

    @Autowired
    InstructorAdventureRepository instructorAdventureRepository;

    @Override
    public List<AdventureReservationDTO> getFreeAdventures(ReservationSearchDTO dto) {
        /*List<AdventureReservationDTO> freeReservations = new ArrayList<>();
        List<Instructor> instructors = instructorRepository.findAll();
        List<AdventureReservation> reservations = adventureReservationRepository.findAll();
        LocalDateTime dateTime = dto.getDate().atTime(8,0,0);
        boolean isInstructorFree = true;

        for (int i=0; i < 4; i++){
            for(int n=0; n < instructors.size(); n++){
                for(InstructorAdventure adventure : instructors.get(n).getAdventures()){
                    for(int j=0; j < reservations.size(); j++){
                        if(reservations.get(j).getInstructorAdventureId().equals(instructors.get(n).getId())
                                && reservations.get(j).getStartTime().equals(dateTime)){
                            isInstructorFree = false;
                            break;
                        }
                    }
                    if (!isInstructorFree)
                        break;
                    freeReservations.add(new AdventureReservationDTO(dto.getClient().getId(),
                            adventure.getId(), dateTime, dateTime.plusHours(3)));
                }
                isInstructorFree = true;
            }
            dateTime = dateTime.plusHours(3);
        }

        return freeReservations;*/
        return null;
    }

    @Override
    public boolean bookAnInstructorAdventure(AdventureReservationDTO dto) {
        if(!reservationTermValid(dto))
            return false;

        Client client = clientRepository.findByEmail(dto.getClientUsername());
        InstructorAdventure adventure = instructorAdventureRepository.findByName(dto.getAdventureName());

        adventureReservationRepository.save(new AdventureReservation(dto.getStartTime(),
                dto.getEndTime(),
                client,
                adventure,
                dto.getBill()));

        return true;
    }

    private boolean reservationTermValid(AdventureReservationDTO dto){

        LocalDateTime newReservationStart = dto.getStartTime();
        LocalDateTime newReservationEnd = dto.getEndTime();

        List<AdventureReservation> reservations = adventureReservationRepository.findAll();

        for(AdventureReservation reservation: reservations){
            if((newReservationStart.isAfter(reservation.getStartTime()) && newReservationStart.isBefore(reservation.getEndTime()))
                || (newReservationEnd.isAfter(reservation.getStartTime()) && newReservationEnd.isBefore(reservation.getEndTime())))
                return false;
        }
        return true;
    }

    @Override
    public List<AdventureReservationDTO> getInstructorReservations(int instructorId) {
        List<AdventureReservationDTO> adventureReservationDTOS = new ArrayList<AdventureReservationDTO>();
        for(AdventureReservation reservation: adventureReservationRepository.getInstructorReservations(instructorId))
            adventureReservationDTOS.add(new AdventureReservationDTO(reservation));
        return adventureReservationDTOS;
    }

    @Override
    public void createAventureReservationReport(AdventureReservationReportDTO dto) {
        adventureReservationReportRepository.save(new AdventureReservationReport(dto.getReportText(),
                adventureReservationRepository.getById(dto.getReservationId())));
    }
}
