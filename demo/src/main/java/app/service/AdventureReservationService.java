package app.service;

import app.dto.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import app.dto.AdventureReservationDTO;
import app.dto.AdventureReservationSearchDTO;

public interface AdventureReservationService{
    List<AdventureReservationDTO> getFreeAdventures(AdventureReservationSearchDTO dto);

    boolean bookAnInstructorAdventure(AdventureReservationDTO dto) throws MessagingException, UnsupportedEncodingException;

    List<AdventureReservationDTO> getInstructorReservations(int instructorId);

    void createAventureReservationReport(AdventureReservationReportDTO dto);

    List<SallaryByDayDTO> getInstructorSallary(LocalDate fromDate, LocalDate toDate, int instructorId);

    List<SallaryByDayDTO> sumSystemSallary(LocalDate fromDate, LocalDate toDate);

    List<ReservationStatisticsDTO> getReservationStatistics(LocalDateTime fromDate, LocalDateTime toDate, Integer instructorId);

    Boolean isAdventureFree(ReservationDTO dto);

    AdventureReservationDTO bookAdventure(AdventureReservationDTO dto);
}
