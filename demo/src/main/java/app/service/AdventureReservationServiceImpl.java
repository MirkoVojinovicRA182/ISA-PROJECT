package app.service;

import app.domain.AdventureReservation;
import app.domain.Instructor;
import app.domain.InstructorAdventure;
import app.dto.AdventureReservationDTO;
import app.dto.AdventureReservationSearchDTO;
import app.repository.AdventureReservationRepository;
import app.repository.ClientRepository;
import app.repository.InstructorAdventureRepository;
import app.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AdventureReservationServiceImpl implements AdventureReservationService{

    @Autowired
    private AdventureReservationRepository adventureReservationRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InstructorAdventureRepository instructorAdventureRepository;

    @Override
    public List<AdventureReservationDTO> getFreeAdventures(AdventureReservationSearchDTO dto) {
        List<AdventureReservationDTO> freeReservations = new ArrayList<>();
        List<Instructor> instructors = instructorRepository.findAll();
        List<AdventureReservation> reservations = adventureReservationRepository.findAll();
        LocalDateTime dateTime = dto.getDate().atTime(dto.getHours(),0,0);
        boolean isInstructorFree = true;

        for (int i=0; i < 1; i++){
            for(int n=0; n < instructors.size(); n++){
                for(InstructorAdventure adventure : instructors.get(n).getAdventures()){
                    for(int j=0; j < reservations.size(); j++){
                        if(reservations.get(j).getInstructorAdventure().getMaxCountOfParticipants() >= dto.getMaxCountOfParticipants()) {
                            if (reservations.get(j).getInstructorAdventure().getInstructor().getId().equals(instructors.get(n).getId())
                                    && reservations.get(j).getStartTime().equals(dateTime)) {
                                isInstructorFree = false;
                                break;
                            }
                        }
                    }
                    if (!isInstructorFree)
                        break;
                    freeReservations.add(new AdventureReservationDTO(dto.getClientId(),
                            adventure.getId(), dateTime, dateTime.plusHours(3), adventure.getPricelist()));
                }
                isInstructorFree = true;
            }
            //dateTime = dateTime.plusHours(3);
        }

        return freeReservations;
    }

    @Override
    public void bookAnInstructorAdventure(AdventureReservationDTO dto) {
        InstructorAdventure adventure = instructorAdventureRepository.getByAdventureId(dto.getInstructorAdventureId());
        adventureReservationRepository.save(new AdventureReservation(dto.getStartTime(), dto.getEndTime(),
                clientRepository.getById(dto.getClientId()),
                adventure, adventure.getPricelist()));
    }

    private InstructorAdventure getAventureWithoutInstructor(InstructorAdventure a){
        return new InstructorAdventure(a.getInstructor().getId(), a.getName(), a.getAddress(), a.getPromotionalDescription(), a.getInstructorBiography(),
                a.getMaxCountOfParticipants(), a.getRulesOfConduct(), a.getDefaultEquipment(), a.getPricelist(),
                a.getTermsOfUse(),
                new Instructor(a.getInstructor().getId(), a.getInstructor().getEmail(), a.getInstructor().getPassword(),
                        a.getInstructor().getName(), a.getInstructor().getLastName(), a.getInstructor().getAddress(),
                        a.getInstructor().getCity(), a.getInstructor().getCountry(), a.getInstructor().getPhoneNumber()));
    }
}
