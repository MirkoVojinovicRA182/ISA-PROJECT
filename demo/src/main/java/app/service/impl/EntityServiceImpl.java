package app.service.impl;

import app.domain.*;
import app.domain.enums.UserType;
import app.dto.*;
import app.repository.*;
import app.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private CottageOwnerRepository cottageOwnerRepository;

    @Autowired
    private ShipOwnerRepository shipOwnerRepository;

    @Autowired
    private InstructorAdventureRepository instructorAdventureRepository;

    @Autowired
    private CottageRepository cottageRepository;

    @Autowired
    private ShipRepository shipRepository;

    @Override
    public List<UserProfileDTO> getAllInstructors() {
        List<UserProfileDTO> userProfileDTOS = new ArrayList<UserProfileDTO>();
        for(Instructor instructor: instructorRepository.findAll())
            userProfileDTOS.add(new UserProfileDTO(instructor));
        return userProfileDTOS;
    }

    @Override
    public List<InstructorAdventureDTO> getAllInstructorAdventures() {
        List<InstructorAdventureDTO> adventureDTOS = new ArrayList<InstructorAdventureDTO>();
        for(InstructorAdventure adventure: instructorAdventureRepository.findAll())
            adventureDTOS.add(new InstructorAdventureDTO(adventure));
        return adventureDTOS;
    }

    @Override
    public UserRequest getInstructorById(Integer id) {
        Instructor instructor = instructorRepository.findById(id).orElseGet(null);
        if(instructor != null)
            return new UserRequest(instructor.getId(), instructor.getEmail(), instructor.getName(),
                    instructor.getLastName(), instructor.getAddress(), instructor.getCity(), instructor.getCountry(),
                    instructor.getPhoneNumber(), "INSTRUCTOR");
        return null;
    }

    @Override
    public UserRequest getAdministratorById(Integer id) {
        Administrator administrator = administratorRepository.findById(id).orElseGet(null);
        if(administrator != null)
            return new UserRequest(administrator.getId(), administrator.getEmail(), administrator.getName(),
                    administrator.getLastName(), administrator.getAddress(), administrator.getCity(), administrator.getCountry(),
                    administrator.getPhoneNumber(), "ADMINISTRATOR");
        return null;
    }

    @Override
    public List<CottageDTO> getAllCottages() {
        List<CottageDTO> cottageDTOS = new ArrayList<CottageDTO>();
        for (Cottage cottage: cottageRepository.findAll())
            cottageDTOS.add(new CottageDTO(cottage));

        return cottageDTOS;
    }

    @Override
    public void deleteCottage(Integer cottageId) {
        this.cottageRepository.deleteById(cottageId);
    }

    @Override
    public List<ShipDTO> getAllShips() {
        List<ShipDTO> shipDTOS = new ArrayList<ShipDTO>();
        for(Ship ship: this.shipRepository.findAll())
            shipDTOS.add(new ShipDTO(ship));
        return shipDTOS;
    }

    @Override
    public void deleteShip(Integer shipId) {
        this.shipRepository.deleteById(shipId);
    }

    @Override
    public UserRequest getCottageOwnerById(Integer id) {
        CottageOwner cottageOwner = cottageOwnerRepository.findById(id).orElseGet(null);
        if(cottageOwner != null)
            return new UserRequest(cottageOwner.getId(), cottageOwner.getEmail(), cottageOwner.getName(),
                    cottageOwner.getLastName(), cottageOwner.getAddress(), cottageOwner.getCity(), cottageOwner.getCountry(),
                    cottageOwner.getPhoneNumber(), "COTTAGE_OWNER");
        return null;
    }

    @Override
    public UserRequest getShipOwnerById(Integer id) {
        ShipOwner shipOwner = shipOwnerRepository.findById(id).orElseGet(null);
        if(shipOwner != null)
            return new UserRequest(shipOwner.getId(), shipOwner.getEmail(), shipOwner.getName(),
                    shipOwner.getLastName(), shipOwner.getAddress(), shipOwner.getCity(), shipOwner.getCountry(),
                    shipOwner.getPhoneNumber(), "SHIP_OWNER");
        return null;
    }
}
