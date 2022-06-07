package app.service.impl;

import app.domain.*;
import app.domain.enums.UserType;
import app.dto.ComplaintDTO;
import app.dto.CottageOwnerDTO;
import app.dto.RatingDTO;
import app.dto.UserProfileDTO;
import app.repository.*;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorAdventureRepository adventureRepository;

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private CottageRepository cottageRepository;

    @Autowired
    private CottageOwnerRepository cottageOwnerRepository;

    @Autowired
    private ShipOwnerRepository shipOwnerRepository;

    @Autowired
    private AdventureReservationRepository adventureReservationRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private CottageComplaintRepository cottageComplaintRepository;

    @Autowired
    private InstructorComplaintRepository instructorComplaintRepository;

    @Autowired
    private ShipComplaintRepository shipComplaintRepository;

    @Override
    public Collection<UserProfileDTO> getUsers() {

        List<UserProfileDTO> users = new ArrayList<UserProfileDTO>();

        List<Administrator> admins = administratorRepository.findAll();
        List<Client> clients = clientRepository.findAll();
        List<Instructor> instructors = instructorRepository.findAll();
        List<CottageOwner> cottageOwners = cottageOwnerRepository.findAll();
        List<ShipOwner> shipOwners = shipOwnerRepository.findAll();

        for(Administrator admin: admins)
        {
            UserProfileDTO userProfileDTO = new UserProfileDTO(admin);
            userProfileDTO.setUserType("ROLE_ADMINISTRATOR");
            users.add(userProfileDTO);
        }

        for(Client client: clients)
        {
            UserProfileDTO userProfileDTO = new UserProfileDTO(client);
            userProfileDTO.setUserType("ROLE_CLIENT");
            users.add(userProfileDTO);
        }

        for(Instructor instructor: instructors)
        {
            UserProfileDTO userProfileDTO = new UserProfileDTO(instructor);
            userProfileDTO.setUserType("ROLE_INSTRUCTOR");
            users.add(userProfileDTO);
        }

        for(CottageOwner cottageOwner: cottageOwners)
        {
            UserProfileDTO userProfileDTO = new UserProfileDTO(cottageOwner);
            userProfileDTO.setUserType("ROLE_COTTAGE_OWNER");
            users.add(userProfileDTO);
        }

        for(ShipOwner shipOwner: shipOwners)
        {
            UserProfileDTO userProfileDTO = new UserProfileDTO(shipOwner);
            userProfileDTO.setUserType("ROLE_SHIP_OWNER");
            users.add(userProfileDTO);
        }

        return users;
    }

    @Override
    public void deleteUser(Integer userId, UserType userType) {
        if(userType.equals(UserType.ADMINISTRATOR))
            administratorRepository.deleteById(userId);
        else if(userType.equals(UserType.CLIENT)){

            List<AdventureReservation> clientReservations = adventureReservationRepository.findByClientId(userId);

            for(AdventureReservation adventureReservation: clientReservations){
                adventureReservation.setClient(null);
                adventureReservationRepository.save(adventureReservation);
            }

            clientRepository.deleteById(userId);
        }
        else if(userType.equals(UserType.INSTRUCTOR)){
            List<AdventureReservation> instructorReservations = adventureReservationRepository.getInstructorReservations(userId);

            for(AdventureReservation adventureReservation: instructorReservations){
                adventureReservation.setAdventure(null);
                adventureReservationRepository.save(adventureReservation);
            }

            instructorRepository.deleteById(userId);
        }
        else if(userType.equals(UserType.COTTAGE_OWNER))
            cottageOwnerRepository.deleteById(userId);
        else if(userType.equals(UserType.SHIP_OWNER))
            shipOwnerRepository.deleteById(userId);
    }

    @Override
    public UserProfileDTO getClient(String username) {
        Client user = clientRepository.findByEmail(username);
        if(user != null)
            return new UserProfileDTO(user);
        return null;
    }

    @Override
    public UserProfileDTO getCottageOwner(String username) {
        CottageOwner user = cottageOwnerRepository.findByEmail(username);
        if(user != null)
            return new UserProfileDTO(user);
        return null;
    }

    @Override
    public UserProfileDTO updateCottageOwner(UserProfileDTO userProfileDTO) {
        CottageOwner cottageOwner = cottageOwnerRepository.findByEmail(userProfileDTO.getEmail());
        if(cottageOwner != null){
            cottageOwner.setName(userProfileDTO.getName());
            cottageOwner.setLastName(userProfileDTO.getLastName());
            cottageOwner.setPhoneNumber(userProfileDTO.getPhoneNumber());
            cottageOwner.setAddress(userProfileDTO.getAddress());
            cottageOwner.setCity(userProfileDTO.getCity());
            cottageOwner.setCountry(userProfileDTO.getCountry());
            cottageOwnerRepository.save(cottageOwner);
            return new UserProfileDTO(cottageOwner);
        }

        return null;
    }
    
    public ApplicationUser findByUsername(String username) {
        if (cottageOwnerRepository.findByEmail(username) != null)
            return cottageOwnerRepository.findByEmail(username);

        if (shipOwnerRepository.findByEmail(username) != null)
            return shipOwnerRepository.findByEmail(username);

        if (instructorRepository.findByEmail(username) != null)
            return instructorRepository.findByEmail(username);

        if (administratorRepository.findByEmail(username) != null)
            return administratorRepository.findByEmail(username);

        if (clientRepository.findByEmail(username) != null) {
            return clientRepository.findByEmail(username);

        }
        return null;
    }

    @Override
    public RatingDTO rateAdventure(RatingDTO dto) {
        ratingRepository.save(new Rating(dto.getClientId(), dto.getEntityId(), dto.getEntityRate(),
                dto.getRated(), dto.getOwnerId(), dto.getOwnerRate(), dto.getReservationId(), dto.getText()));
        InstructorAdventure adventure = adventureRepository.findById(dto.getEntityId()).orElseGet(null);
        Double rating = 0.0;
        List<Rating> ratings = ratingRepository.findAll();
        int count = ratings.size();
        for(Rating r: ratings){
            if(r.getEntityId().equals(dto.getEntityId()))
                rating += r.getEntityRate();
        }

        adventure.setRating(rating/count);

        adventureRepository.save(adventure);
        return dto;
    }

    @Override
    public RatingDTO rateShip(RatingDTO dto) {
        ratingRepository.save(new Rating(dto.getClientId(), dto.getEntityId(), dto.getEntityRate(),
                dto.getRated(), dto.getOwnerId(), dto.getOwnerRate(), dto.getReservationId(), dto.getText()));
        Ship ship = shipRepository.findById(dto.getEntityId()).orElseGet(null);
        Double rating = ship.getRating();
        List<Rating> ratings = ratingRepository.findAll();
        int count = ratings.size();
        for(Rating r: ratings){
            if(r.getEntityId().equals(dto.getEntityId()))
                rating += r.getEntityRate();
        }

        ship.setRating(rating/count);

        shipRepository.save(ship);
        return dto;
    }

    @Override
    public RatingDTO rateCottage(RatingDTO dto) {
        ratingRepository.save(new Rating(dto.getClientId(), dto.getEntityId(), dto.getEntityRate(),
                dto.getRated(), dto.getOwnerId(), dto.getOwnerRate(), dto.getReservationId(), dto.getText()));
        Cottage cottage = cottageRepository.findById(dto.getEntityId()).orElseGet(null);
        Double rating = cottage.getRating();
        List<Rating> ratings = ratingRepository.findAll();
        int count = ratings.size();
        for(Rating r: ratings){
            if(r.getEntityId().equals(dto.getEntityId()))
                rating += r.getEntityRate();
        }

        cottage.setRating(rating/count);

        cottageRepository.save(cottage);
        return dto;
    }

    @Override
    public ComplaintDTO complaintCottage(ComplaintDTO dto) {
        Cottage cottage = cottageRepository.findById(dto.getEntityId()).orElseGet(null);
        Client client = clientRepository.findById(dto.getClientId()).orElseGet(null);
        CottageOwner cottageOwner = cottageOwnerRepository.findById(dto.getOwnerId()).orElseGet(null);
        cottageComplaintRepository.save(new CottageComplaint(dto.getText(), cottage, cottageOwner, client));

        return dto;
    }

    @Override
    public ComplaintDTO complaintShip(ComplaintDTO dto) {
        Ship ship = shipRepository.findById(dto.getEntityId()).orElseGet(null);
        Client client = clientRepository.findById(dto.getClientId()).orElseGet(null);
        ShipOwner shipOwner = shipOwnerRepository.findById(dto.getOwnerId()).orElseGet(null);
        shipComplaintRepository.save(new ShipComplaint(dto.getText(), ship, shipOwner, client));

        return dto;
    }

    @Override
    public ComplaintDTO complaintAdventure(ComplaintDTO dto) {
        Client client = clientRepository.findById(dto.getClientId()).orElseGet(null);
        Instructor instructor = instructorRepository.findById(dto.getOwnerId()).orElseGet(null);
        instructorComplaintRepository.save(new InstructorComplaint(dto.getText(), instructor, client));

        return dto;
    }
}
