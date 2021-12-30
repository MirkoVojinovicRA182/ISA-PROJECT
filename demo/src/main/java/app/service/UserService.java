package app.service;

import app.domain.enums.UserType;
import app.dto.UserProfileDTO;

import java.util.Collection;

public interface UserService {
    Collection<UserProfileDTO> getUsers();

    void deleteUser(Integer userId, UserType userType);
}
