package app.service;

import app.domain.AdventureAdditionalService;
import app.domain.Image;
import app.domain.Instructor;
import app.domain.InstructorAdventure;
import app.dto.AdventureAdditionalServiceDTO;
import app.dto.ImageDTO;
import app.dto.InstructorAdventureDTO;
import app.repository.AdventureAdditionalServiceRepository;
import app.repository.ImageRepository;
import app.repository.InstructorAdventureRepository;
import app.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorAdventureServiceImpl implements InstructorAdventureService{

    @Autowired
    private InstructorAdventureRepository instructorAdventureRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private AdventureAdditionalServiceRepository additionalServiceRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void saveAdventure(InstructorAdventureDTO dto) {
        InstructorAdventure adventure = new InstructorAdventure(
                dto.getName(),
                dto.getAddress(),
                dto.getPromotionalDescription(),
                dto.getInstructorBiography(),
                dto.getMaxCountOfParticipants(),
                dto.getRulesOfConduct(),
                dto.getDefaultEquipment(),
                dto.getPrice(),
                dto.getTermsOfUse(),
                instructorRepository.getById(dto.getInstructorId()));
        instructorAdventureRepository.save(adventure);
    }

    @Override
    public List<InstructorAdventureDTO> getAdventuresByInstructorId(Integer instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElseGet(null);
        List<InstructorAdventureDTO> adventures = new ArrayList<InstructorAdventureDTO>();
        for(InstructorAdventure a: instructor.getAdventures())
            adventures.add(new InstructorAdventureDTO(a));
        return adventures;
    }

    @Override
    public void deleteAdventure(Integer adventureId) {
        instructorAdventureRepository.deleteById(adventureId);
    }

    @Override
    public InstructorAdventureDTO updateAdventure(InstructorAdventureDTO dto) {
        InstructorAdventure adventure = instructorAdventureRepository.findById(dto.getId()).orElseGet(null);
        adventure.update(dto);
        instructorAdventureRepository.save(adventure);
        return new InstructorAdventureDTO(adventure);
    }

    @Override
    public InstructorAdventureDTO getAdventureById(Integer id) {
        InstructorAdventure adventure = instructorAdventureRepository.findById(id).orElseGet(null);
        if(adventure != null)
            return new InstructorAdventureDTO(adventure);
        return null;
    }

    @Override
    public List<AdventureAdditionalServiceDTO> getAdditionalServices(Integer aventureId) {
        InstructorAdventure adventure = instructorAdventureRepository.findById(aventureId).orElseGet(null);

        List<AdventureAdditionalServiceDTO> additionalServiceDTOS = new ArrayList<AdventureAdditionalServiceDTO>();
        if(adventure != null){
            for(AdventureAdditionalService additionalService: adventure.getAdditionalServices())
                additionalServiceDTOS.add(new AdventureAdditionalServiceDTO(additionalService));
        }

        return additionalServiceDTOS;
    }

    @Override
    public void saveAdditionalService(AdventureAdditionalServiceDTO dto) {
        additionalServiceRepository.save(new AdventureAdditionalService(
                dto.getName(),
                dto.getPrice(),
                instructorAdventureRepository.getById(dto.getAdventureId())));
    }

    @Override
    public void deleteAdditionalService(Integer id) {
        additionalServiceRepository.deleteById(id);
    }

    @Override
    public List<ImageDTO> getImages(Integer adventureId) {
        List<ImageDTO> images = new ArrayList<ImageDTO>();
        InstructorAdventure adventure = instructorAdventureRepository.findById(adventureId).orElseGet(null);
        if(adventure != null)
            for(Image image : adventure.getImages())
                images.add(new ImageDTO(image));

        return images;
    }

    @Override
    public void deleteImage(Integer id) {
        imageRepository.deleteById(id);
    }

    @Override
    public void addImage(ImageDTO dto) {
        InstructorAdventure adventure = instructorAdventureRepository.getById(dto.getAdventureId());

        imageRepository.save(new Image(dto.getUrl(), adventure));
    }


}
