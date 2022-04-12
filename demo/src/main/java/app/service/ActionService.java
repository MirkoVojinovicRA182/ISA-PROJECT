package app.service;

import app.dto.ActionAdventureDTO;

import java.util.List;

public interface ActionService {

    boolean createAdventureAction(ActionAdventureDTO dto);

    List<ActionAdventureDTO> getActionsByAdventureId(Integer adventureId);

}
