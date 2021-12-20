package app.service;

import app.domain.Body;
import app.domain.Organ;
import app.dto.OrganDTO;
import app.repository.BodyRepository;
import app.repository.OrganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {
    @Autowired
    private OrganRepository organRepository;

    @Autowired
    private BodyRepository bodyRepository;

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

    public Optional<Body> getBody() {
        return bodyRepository.findById(1);
    }
}
