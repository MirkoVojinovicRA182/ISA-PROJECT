package app.service;

import app.domain.*;
import app.domain.enums.UserType;
import app.dto.UserProfileDTO;
import app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CottageOwnerRepository cottageOwnerRepository;

    @Autowired
    private ShipOwnerRepository shipOwnerRepository;


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
            userProfileDTO.setUserType(UserType.Administrator);
            users.add(userProfileDTO);
        }

        for(Client client: clients)
        {
            UserProfileDTO userProfileDTO = new UserProfileDTO(client);
            userProfileDTO.setUserType(UserType.Client);
            users.add(userProfileDTO);
        }

        for(Instructor instructor: instructors)
        {
            UserProfileDTO userProfileDTO = new UserProfileDTO(instructor);
            userProfileDTO.setUserType(UserType.Instructor);
            users.add(userProfileDTO);
        }

        for(CottageOwner cottageOwner: cottageOwners)
        {
            UserProfileDTO userProfileDTO = new UserProfileDTO(cottageOwner);
            userProfileDTO.setUserType(UserType.CottageOwner);
            users.add(userProfileDTO);
        }

        for(ShipOwner shipOwner: shipOwners)
        {
            UserProfileDTO userProfileDTO = new UserProfileDTO(shipOwner);
            userProfileDTO.setUserType(UserType.ShipOwner);
            users.add(userProfileDTO);
        }

        return users;
    }

    @Override
    public void deleteUser(Integer userId, UserType userType) {
        if(userType.equals(UserType.Administrator))
            administratorRepository.deleteById(userId);
        else if(userType.equals(UserType.Client))
            clientRepository.deleteById(userId);
        else if(userType.equals(UserType.Instructor))
            instructorRepository.deleteById(userId);
        else if(userType.equals(UserType.CottageOwner))
            cottageOwnerRepository.deleteById(userId);
        else if(userType.equals(UserType.ShipOwner))
            shipOwnerRepository.deleteById(userId);
    }
}
