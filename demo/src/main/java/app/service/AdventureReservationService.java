package app.service;

import app.dto.AdventureReservationDTO;
import app.dto.AdventureReservationReportDTO;
import app.dto.ReservationSearchDTO;
import app.dto.SallaryByDayDTO;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AdventureReservationService{
    List<AdventureReservationDTO> getFreeAdventures(ReservationSearchDTO dto);

    boolean bookAnInstructorAdventure(AdventureReservationDTO dto) throws MessagingException, UnsupportedEncodingException;

    List<AdventureReservationDTO> getInstructorReservations(int instructorId);

    void createAventureReservationReport(AdventureReservationReportDTO dto);

    List<SallaryByDayDTO> getInstructorSallary(LocalDate fromDate, LocalDate toDate, int instructorId);

    List<SallaryByDayDTO> sumSystemSallary(LocalDate fromDate, LocalDate toDate);
}
