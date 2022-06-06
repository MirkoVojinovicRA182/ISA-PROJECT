package app.service.impl;

import app.domain.AdventureReservation;
import app.domain.Instructor;
import app.domain.InstructorAdventure;
import app.dto.AdventureReservationDTO;
import app.dto.AdventureReservationSearchDTO;
import app.repository.AdventureReservationRepository;
import app.repository.ClientRepository;
import app.repository.InstructorAdventureRepository;
import app.repository.InstructorRepository;
import app.domain.*;
import app.dto.*;
import app.repository.*;
import app.service.AdventureReservationService;
import app.utility.Utility;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AdventureReservationServiceImpl implements AdventureReservationService {

    @Autowired
    private AdventureReservationRepository adventureReservationRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InstructorAdventureRepository instructorAdventureRepository;

    @Override
    public List<AdventureReservationDTO> getFreeAdventures(AdventureReservationSearchDTO dto) {
        List<AdventureReservationDTO> freeReservations = new ArrayList<>();
        return freeReservations;
    }

    private AdventureReservationReportRepository adventureReservationReportRepository;

    @Autowired
    ActionAdventureRepository actionAdventureRepository;

    /*@Override
    public List<AdventureReservationDTO> getFreeAdventures(AdventureReservationSearchDTO dto) {
        List<AdventureReservationDTO> freeReservations = new ArrayList<>();
        List<Instructor> instructors = instructorRepository.findAll();
        List<AdventureReservation> reservations = adventureReservationRepository.findAll();
        LocalDateTime dateTime = dto.getDate().atTime(dto.getHours(),0,0);
        boolean isInstructorFree = true;

        for (int i=0; i < 1; i++){
            for(int n=0; n < instructors.size(); n++){
                for(InstructorAdventure adventure : instructors.get(n).getAdventures()){
                    for(int j=0; j < reservations.size(); j++){
                        if(reservations.get(j).getInstructorAdventure().getMaxCountOfParticipants() >= dto.getMaxCountOfParticipants()) {
                            if (reservations.get(j).getInstructorAdventure().getInstructor().getId().equals(instructors.get(n).getId())
                                    && reservations.get(j).getStartTime().equals(dateTime)) {
                                isInstructorFree = false;
                                break;
                            }
                        }
                    }
                    if (!isInstructorFree)
                        break;
                    freeReservations.add(new AdventureReservationDTO(dto.getClientId(),
                            adventure.getId(), dateTime, dateTime.plusHours(3), adventure.getPricelist()));
                }
                isInstructorFree = true;
            }
            //dateTime = dateTime.plusHours(3);
        }

        return freeReservations;
        return null;
    }*/

    @Override
    public boolean bookAnInstructorAdventure(AdventureReservationDTO dto) throws MessagingException, UnsupportedEncodingException {
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

    @Override
    public List<SallaryByDayDTO> getInstructorSallary(LocalDate fromDate, LocalDate toDate, int instructorId) {

        List<SallaryByDayDTO> list = new ArrayList<SallaryByDayDTO>();

        DecimalFormat df = new DecimalFormat("0.00");

        for(LocalDate date = fromDate; date.isBefore(toDate.plusDays(1)); date = date.plusDays(1)){

            String dateFormat = String.valueOf(date.getDayOfMonth()) + "." +
                    String.valueOf(date.getMonthValue()) + "." +
                    String.valueOf(date.getYear()) + ".";

            double currentBill = 0;

            for(AdventureReservation reservation: adventureReservationRepository.getInstructorReservations(instructorId)) {

                if (reservation.getEndTime().getDayOfMonth() == date.getDayOfMonth() &&
                    reservation.getEndTime().getMonthValue() == date.getMonthValue() &&
                    reservation.getEndTime().getYear() == date.getYear())
                        currentBill += reservation.getBill() - reservation.getBill() * reservation.getSystemSallary();
            }

            list.add(new SallaryByDayDTO(dateFormat, Double.valueOf(df.format(currentBill))));

            currentBill = 0;
        }

        return list;

    }
    
    public List<SallaryByDayDTO> sumSystemSallary(LocalDate fromDate, LocalDate toDate) {
        List<SallaryByDayDTO> list = new ArrayList<SallaryByDayDTO>();

        DecimalFormat df = new DecimalFormat("0.00");

        for(LocalDate date = fromDate; date.isBefore(toDate.plusDays(1)); date = date.plusDays(1)){

            String dateFormat = String.valueOf(date.getDayOfMonth()) + "." +
                    String.valueOf(date.getMonthValue()) + "." +
                    String.valueOf(date.getYear()) + ".";

            double currentBill = 0;

            for(AdventureReservation reservation: adventureReservationRepository.findAll()) {

                if (reservation.getEndTime().getDayOfMonth() == date.getDayOfMonth() &&
                        reservation.getEndTime().getMonthValue() == date.getMonthValue() &&
                        reservation.getEndTime().getYear() == date.getYear())
                    currentBill += reservation.getBill() * reservation.getSystemSallary();
            }

            list.add(new SallaryByDayDTO(dateFormat, Double.valueOf(df.format(currentBill))));

            currentBill = 0;
        }

        return list;
    }

    @Override
    public List<ReservationStatisticsDTO> getReservationStatistics(LocalDateTime fromDate, LocalDateTime toDate, Integer instructorId) {

        List<ReservationStatisticsDTO> statisticsDTOS = new ArrayList<ReservationStatisticsDTO>();

        for(AdventureReservation reservation: adventureReservationRepository.getInstructorReservationsByDateRange(fromDate, toDate, instructorId)){
            statisticsDTOS.add(new ReservationStatisticsDTO(reservation.getAdventure().getName(), reservation.getStartTime(),
                    reservation.getEndTime()));
        }


        return statisticsDTOS;
    }

    @Override
    public Boolean isAdventureFree(ReservationDTO dto) {
        if(dto.getStartTime().isAfter(dto.getEndTime()))
            return false;

        List<AdventureReservation> reservations = adventureReservationRepository.findAll();
        if (reservations.size() == 0)
            return true;
        for (AdventureReservation res: reservations){
            if(res.getAdventure().getId() == dto.getId()){
                if((res.getStartTime().getYear() == dto.getStartTime().getYear()
                        && res.getStartTime().getDayOfMonth() == dto.getStartTime().getDayOfMonth()
                        && res.getStartTime().getMonth() == dto.getStartTime().getMonth())
                        || instructorIsNotFree(dto)){
                    return false;
                }
            }
        }


        return true;
    }

    private boolean instructorIsNotFree(ReservationDTO dto) {
        InstructorAdventure instructorAdventure = instructorAdventureRepository.findById(dto.getId()).orElseGet(null);
        if(instructorAdventure == null)
            return true;
        Instructor instructor = instructorAdventure.getInstructor();
        List<AdventureReservation> reservations = adventureReservationRepository.findAll();
        Set<InstructorAdventure> adventures =  instructor.getAdventures();
        for (InstructorAdventure adv: adventures){
            for(AdventureReservation res: reservations){
                if(adv.getId() == res.getAdventure().getId()){
                    if(res.getStartTime().getYear() == dto.getStartTime().getYear()
                            && res.getStartTime().getDayOfMonth() == dto.getStartTime().getDayOfMonth()
                            && res.getStartTime().getMonth() == dto.getStartTime().getMonth()){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public AdventureReservationDTO bookAdventure(AdventureReservationDTO dto) {
        Client client = clientRepository.findById(dto.getClientId()).orElseGet(null);
        InstructorAdventure adventure = instructorAdventureRepository.findById(dto.getAdventureId()).orElseGet(null);
        adventureReservationRepository.save(new AdventureReservation(dto, adventure, client));
        return dto;
    }


}
