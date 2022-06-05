package app.service.impl;

import app.domain.*;
import app.dto.ActionAdventureDTO;
import app.dto.ReservationCheckDTO;
import app.dto.SubscriptionDTO;
import app.repository.*;
import app.service.ActionService;
import app.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionAdventureRepository actionAdventureRepository;

    @Autowired
    private InstructorAdventureRepository instructorAdventureRepository;

    @Autowired
    private AdventureReservationRepository adventureReservationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CottageSubscriptionRepository cottageSubscriptionRepository;

    @Autowired
    private AdventureSubscriptionRepository adventureSubscriptionRepository;

    @Autowired
    private ShipSubscriptionRepository shipSubscriptionRepository;

    @Autowired
    private UserSubscriptionRepository userSubscriptionRepository;

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

    @Override
    public List<SubscriptionDTO> getCottagesSubscriptions() {
        List<SubscriptionDTO> dtos = new ArrayList<SubscriptionDTO>();

        for(Subscription subscription: cottageSubscriptionRepository.findAll())
            dtos.add(new SubscriptionDTO(subscription.getId(), subscription.getClientId(), subscription.getSubscribedTo()));

        return dtos;
    }

    @Override
    public List<SubscriptionDTO> getAdventuresSubscriptions() {
        List<SubscriptionDTO> dtos = new ArrayList<SubscriptionDTO>();

        for(Subscription subscription: shipSubscriptionRepository.findAll())
            dtos.add(new SubscriptionDTO(subscription.getId(), subscription.getClientId(), subscription.getSubscribedTo()));

        return dtos;
    }

    @Override
    public List<SubscriptionDTO> getShipsSubscriptions() {
        List<SubscriptionDTO> dtos = new ArrayList<SubscriptionDTO>();

        for(Subscription subscription: adventureSubscriptionRepository.findAll())
            dtos.add(new SubscriptionDTO(subscription.getId(), subscription.getClientId(), subscription.getSubscribedTo()));

        return dtos;
    }

    @Override
    public List<SubscriptionDTO> getUserSubscriptions() {
        List<SubscriptionDTO> dtos = new ArrayList<SubscriptionDTO>();

        for(Subscription subscription: adventureSubscriptionRepository.findAll())
            dtos.add(new SubscriptionDTO(subscription.getId(), subscription.getClientId(), subscription.getSubscribedTo()));

        return dtos;
    }

    @Override
    public SubscriptionDTO adventureSubscribe(SubscriptionDTO subscriptionDTO) {
        AdventureSubscription newSubscription = new AdventureSubscription(subscriptionDTO.getClientId(), subscriptionDTO.getSubscribedTo());
        adventureSubscriptionRepository.save(newSubscription);
        return subscriptionDTO;
    }

    @Override
    public SubscriptionDTO adventureUnSubscribe(SubscriptionDTO subscriptionDTO) {
        List<AdventureSubscription> subscriptions= adventureSubscriptionRepository.findAll();
        for(AdventureSubscription subscription: subscriptions)
            if(subscription.getClientId() == subscriptionDTO.getClientId() && subscription.getSubscribedTo() == subscriptionDTO.getSubscribedTo())
                adventureSubscriptionRepository.delete(subscription);

        return subscriptionDTO;
    }

    @Override
    public SubscriptionDTO shipSubscribe(SubscriptionDTO subscriptionDTO) {
        ShipSubscription newSubscription = new ShipSubscription(subscriptionDTO.getClientId(), subscriptionDTO.getSubscribedTo());
        shipSubscriptionRepository.save(newSubscription);
        return subscriptionDTO;
    }

    @Override
    public SubscriptionDTO shipUnSubscribe(SubscriptionDTO subscriptionDTO) {
        List<ShipSubscription> subscriptions= shipSubscriptionRepository.findAll();
        for(ShipSubscription subscription: subscriptions)
            if(subscription.getClientId() == subscriptionDTO.getClientId() && subscription.getSubscribedTo() == subscriptionDTO.getSubscribedTo())
                shipSubscriptionRepository.delete(subscription);

        return subscriptionDTO;
    }

    @Override
    public SubscriptionDTO cottageSubscribe(SubscriptionDTO subscriptionDTO) {
        CottageSubscription newSubscription = new CottageSubscription(subscriptionDTO.getClientId(), subscriptionDTO.getSubscribedTo());
        cottageSubscriptionRepository.save(newSubscription);
        return subscriptionDTO;
    }

    @Override
    public SubscriptionDTO cottageUnSubscribe(SubscriptionDTO subscriptionDTO) {
        List<CottageSubscription> subscriptions= cottageSubscriptionRepository.findAll();
        for(CottageSubscription subscription: subscriptions)
            if(subscription.getClientId() == subscriptionDTO.getClientId() && subscription.getSubscribedTo() == subscriptionDTO.getSubscribedTo())
                cottageSubscriptionRepository.delete(subscription);

        return subscriptionDTO;
    }

    @Override
    public SubscriptionDTO userSubscribe(SubscriptionDTO subscriptionDTO) {
        UserSubscription newSubscription = new UserSubscription(subscriptionDTO.getClientId(), subscriptionDTO.getSubscribedTo());
        userSubscriptionRepository.save(newSubscription);
        return subscriptionDTO;
    }

    @Override
    public SubscriptionDTO userUnSubscribe(SubscriptionDTO subscriptionDTO) {
        List<UserSubscription> subscriptions= userSubscriptionRepository.findAll();
        for(UserSubscription subscription: subscriptions)
            if(subscription.getClientId() == subscriptionDTO.getClientId() && subscription.getSubscribedTo() == subscriptionDTO.getSubscribedTo())
                userSubscriptionRepository.delete(subscription);

        return subscriptionDTO;
    }

    @Override
    public Boolean isSubscribedToCottage(SubscriptionDTO subscriptionDTO) {
        List<CottageSubscription> subscriptions= cottageSubscriptionRepository.findAll();
        for(CottageSubscription subscription: subscriptions)
            if(subscription.getClientId() == subscriptionDTO.getClientId() && subscription.getSubscribedTo() == subscriptionDTO.getSubscribedTo())
                return true;
        return false;
    }

    @Override
    public Boolean isSubscribedToUser(SubscriptionDTO subscriptionDTO) {
        List<UserSubscription> subscriptions= userSubscriptionRepository.findAll();
        for(UserSubscription subscription: subscriptions)
            if(subscription.getClientId() == subscriptionDTO.getClientId() && subscription.getSubscribedTo() == subscriptionDTO.getSubscribedTo())
                return true;
        return false;
    }

    @Override
    public Boolean isSubscribedToAdventure(SubscriptionDTO subscriptionDTO) {
        List<AdventureSubscription> subscriptions= adventureSubscriptionRepository.findAll();
        for(AdventureSubscription subscription: subscriptions)
            if(subscription.getClientId() == subscriptionDTO.getClientId() && subscription.getSubscribedTo() == subscriptionDTO.getSubscribedTo())
                return true;
        return false;
    }

    @Override
    public Boolean isSubscribedToShip(SubscriptionDTO subscriptionDTO) {
        List<ShipSubscription> subscriptions= shipSubscriptionRepository.findAll();
        for(ShipSubscription subscription: subscriptions)
            if(subscription.getClientId() == subscriptionDTO.getClientId() && subscription.getSubscribedTo() == subscriptionDTO.getSubscribedTo())
                return true;
        return false;
    }
}
