package app.service;

import app.dto.ActionAdventureDTO;
import app.dto.SubscriptionDTO;

import java.util.List;

public interface ActionService {

    boolean createAdventureAction(ActionAdventureDTO dto);

    List<ActionAdventureDTO> getActionsByAdventureId(Integer adventureId);

    List<SubscriptionDTO> getCottagesSubscriptions();

    List<SubscriptionDTO> getAdventuresSubscriptions();

    List<SubscriptionDTO> getShipsSubscriptions();

    List<SubscriptionDTO> getUserSubscriptions();

    SubscriptionDTO adventureSubscribe(SubscriptionDTO subscriptionDTO);

    SubscriptionDTO adventureUnSubscribe(SubscriptionDTO subscriptionDTO);

    SubscriptionDTO shipSubscribe(SubscriptionDTO subscriptionDTO);

    SubscriptionDTO shipUnSubscribe(SubscriptionDTO subscriptionDTO);

    SubscriptionDTO cottageSubscribe(SubscriptionDTO subscriptionDTO);

    SubscriptionDTO cottageUnSubscribe(SubscriptionDTO subscriptionDTO);

    SubscriptionDTO userSubscribe(SubscriptionDTO subscriptionDTO);

    SubscriptionDTO userUnSubscribe(SubscriptionDTO subscriptionDTO);

    Boolean isSubscribedToCottage(SubscriptionDTO subscriptionDTO);

    Boolean isSubscribedToUser(SubscriptionDTO subscriptionDTO);

    Boolean isSubscribedToAdventure(SubscriptionDTO subscriptionDTO);

    Boolean isSubscribedToShip(SubscriptionDTO subscriptionDTO);
}
