package app.service;

import app.domain.ApplicationUser;
import app.dto.LoginDTO;

public interface LoginService {
    ApplicationUser getUser(LoginDTO dto);
}
