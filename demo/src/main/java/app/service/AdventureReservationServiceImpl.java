package app.service;

import app.domain.*;
import app.dto.*;
import app.repository.*;
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

    @Autowired
    ActionAdventureRepository actionAdventureRepository;

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
    public boolean bookAnInstructorAdventure(AdventureReservationDTO dto) throws MessagingException, UnsupportedEncodingException {

        boolean invalidTerm = !Utility.reservationTermValid(new ReservationCheckDTO(dto.getStartTime(), dto.getEndTime(), adventureReservationRepository.findAll(),
                actionAdventureRepository.findAll()));

        if(invalidTerm)
            return false;

        Client client = clientRepository.findByEmail(dto.getClientUsername());
        InstructorAdventure adventure = instructorAdventureRepository.findByName(dto.getAdventureName());

        adventureReservationRepository.save(new AdventureReservation(dto.getStartTime(),
                dto.getEndTime(),
                client,
                adventure,
                dto.getBill(),
                Utility.getSystemSallary()));

        Utility.sendMail(dto.getClientUsername(), "New adventure reservation", "You have new adventure reservation.");

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

    @Override
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


}
