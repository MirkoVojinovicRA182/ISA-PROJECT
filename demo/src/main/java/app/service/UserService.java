package app.service;

import app.domain.ApplicationUser;
import app.domain.Client;
import app.domain.enums.UserType;
import app.dto.ComplaintDTO;
import app.dto.CottageOwnerDTO;
import app.dto.RatingDTO;
import app.dto.UserProfileDTO;
import org.springframework.boot.ApplicationArguments;

import java.util.Collection;

public interface UserService {
    Collection<UserProfileDTO> getUsers();

    void deleteUser(Integer userId, UserType userType);

    UserProfileDTO getClient(String username);

    UserProfileDTO getCottageOwner(String username);

    UserProfileDTO updateCottageOwner(UserProfileDTO userProfileDTO);
    
    ApplicationUser findByUsername(String username);

    RatingDTO rateAdventure(RatingDTO dto);

    RatingDTO rateShip(RatingDTO dto);

    RatingDTO rateCottage(RatingDTO dto);

    ComplaintDTO complaintCottage(ComplaintDTO dto);

    ComplaintDTO complaintShip(ComplaintDTO dto);

    ComplaintDTO complaintAdventure(ComplaintDTO dto);
}
