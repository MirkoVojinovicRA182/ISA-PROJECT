package app.service;

import app.domain.ActionAdventure;
import app.domain.InstructorAdventure;
import app.dto.ActionAdventureDTO;
import app.dto.ReservationCheckDTO;
import app.repository.ActionAdventureRepository;
import app.repository.AdventureReservationReportRepository;
import app.repository.AdventureReservationRepository;
import app.repository.InstructorAdventureRepository;
import app.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionServiceImpl implements ActionService{

    @Autowired
    private ActionAdventureRepository actionAdventureRepository;

    @Autowired
    private InstructorAdventureRepository instructorAdventureRepository;

    @Autowired
    private AdventureReservationRepository adventureReservationRepository;

    @Override
    public boolean createAdventureAction(ActionAdventureDTO dto) {

        boolean invalidTerm = !Utility.reservationTermValid(new ReservationCheckDTO(dto.getStartTime(), dto.getEndTime(), adventureReservationRepository.findAll(),
                actionAdventureRepository.findAll()));
        if(invalidTerm)
            return false;

        actionAdventureRepository.save(
                new ActionAdventure(dto.getCreationDate(),
                        dto.getStartTime(),
                        dto.getEndTime(),
                        dto.getDuration(),
                        dto.getAdditionalServices(),
                        dto.getPrice(),
                        instructorAdventureRepository.getById(dto.getAdventureId())));
        return true;
    }

    @Override
    public List<ActionAdventureDTO> getActionsByAdventureId(Integer adventureId) {
        List<ActionAdventureDTO> dtos = new ArrayList<ActionAdventureDTO>();

        for(ActionAdventure actionAdventure: actionAdventureRepository.getByAdventureId(adventureId))
            dtos.add(new ActionAdventureDTO(actionAdventure));

        return dtos;
    }
}
