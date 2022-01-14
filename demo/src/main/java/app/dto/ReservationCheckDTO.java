package app.dto;

import app.domain.ActionAdventure;
import app.domain.AdventureReservation;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationCheckDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<AdventureReservation> adventureReservationList;
    private List<ActionAdventure> actionAdventureList;

    public ReservationCheckDTO(LocalDateTime startTime, LocalDateTime endTime, List<AdventureReservation> adventureReservationList, List<ActionAdventure> actionAdventureList) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.adventureReservationList = adventureReservationList;
        this.actionAdventureList = actionAdventureList;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public List<AdventureReservation> getAdventureReservationList() {
        return adventureReservationList;
    }

    public List<ActionAdventure> getActionAdventureList() {
        return actionAdventureList;
    }
}
