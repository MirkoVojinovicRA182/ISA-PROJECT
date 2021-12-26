package app.service;

import app.domain.*;
import app.dto.LoginDTO;
import app.repository.AdministratorRepository;
import app.repository.CottageOwnerRepository;
import app.repository.InstructorRepository;
import app.repository.ShipOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private CottageOwnerRepository cottageOwnerRepository;

    @Autowired
    private ShipOwnerRepository shipOwnerRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private AdministratorRepository administratorRepository;


    @Override
    public ApplicationUser getUser(LoginDTO dto) {
        for(CottageOwner c: cottageOwnerRepository.findAll()){
            if(c.getEmail().equals(dto.getUsername()) && c.getPassword().equals(dto.getPassword()))
                return c;
        }

        for(ShipOwner s: shipOwnerRepository.findAll()){
            if(s.getEmail().equals(dto.getUsername()) && s.getPassword().equals(dto.getPassword()))
                return s;
        }

        for(Instructor i: instructorRepository.findAll()){
            if(i.getEmail().equals(dto.getUsername()) && i.getPassword().equals(dto.getPassword()))
                return i;
        }

        for(Administrator a: administratorRepository.findAll()){
            if(a.getEmail().equals(dto.getUsername()) && a.getPassword().equals(dto.getPassword()))
                return a;
        }

        return null;
    }
}
