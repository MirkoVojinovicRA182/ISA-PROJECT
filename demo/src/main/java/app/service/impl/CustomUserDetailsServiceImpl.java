package app.service.impl;

import app.domain.*;
import app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

// Ovaj servis je namerno izdvojen kao poseban u ovom primeru.
// U opstem slucaju UserServiceImpl klasa bi mogla da implementira UserDetailService interfejs.
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

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

    // Funkcija koja na osnovu username-a iz baze vraca objekat User-a
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Administrator> admins = administratorRepository.findAll();
        List<Client> clients = clientRepository.findAll();
        List<Instructor> instructors = instructorRepository.findAll();
        List<CottageOwner> cottageOwners = cottageOwnerRepository.findAll();
        List<ShipOwner> shipOwners = shipOwnerRepository.findAll();

        for(Administrator user: admins){
            if(username.equals(user.getEmail()))
                return (UserDetails) user;
        }
        for(Client user: clients){
            if(username.equals(user.getEmail()))
                return (UserDetails) user;
        }
        for(Instructor user: instructors){
            if(username.equals(user.getEmail()))
                return (UserDetails) user;
        }
        for(CottageOwner user: cottageOwners){
            if(username.equals(user.getEmail()))
                return (UserDetails) user;
        }
        for(ShipOwner user: shipOwners){
            if(username.equals(user.getEmail()))
                return (UserDetails) user;
        }

        return null;
    }

}

