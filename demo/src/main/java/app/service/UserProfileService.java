package app.service;

import app.dto.UserPasswordDTO;
import app.dto.UserProfileDTO;

public interface UserProfileService {
    UserProfileDTO updatePersonalInfo(UserProfileDTO dto);

    UserProfileDTO updatePassword(UserPasswordDTO userPasswordDTO);
}
