package app.service;

import app.domain.Body;
import app.domain.ClassForDelete;
import app.domain.Organ;
import app.dto.OrganDTO;
import app.repository.BodyRepository;
import app.repository.ClassForDeleteRepository;
import app.repository.OrganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {
    @Autowired
    private OrganRepository organRepository;

    @Autowired
    private BodyRepository bodyRepository;

    @Autowired
    private ClassForDeleteRepository classForDeleteRepository;

    public void saveBody(Body body){
        bodyRepository.save(body);
    }

    public void saveOrgan(OrganDTO dto){
        Body body = bodyRepository.getById(dto.getBodyId());

        Organ organ = new Organ();
        organ.setName(dto.getName());
        organ.setBody(body);

        organRepository.save(organ);
    }

    public Body getBody() {
        return bodyRepository.findById(1).orElseGet(null);
    }

    public void deleteById(Integer id) {
        classForDeleteRepository.deleteById(id);
    }

    public void save(ClassForDelete classForDelete) {
        classForDeleteRepository.save(classForDelete);
    }
}
