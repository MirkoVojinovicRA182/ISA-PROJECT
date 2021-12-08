package app.domain;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class RegistrationRequest {
    private Long id;
    private User userToRegister;
    private LocalDate requestDate;

    public RegistrationRequest() {
    }

    public RegistrationRequest(Long id, User userToRegister, LocalDate requestDate) {
        this.id = id;
        this.userToRegister = userToRegister;
        this.requestDate = requestDate;
    }

    public User getUserToRegister() {
        return userToRegister;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserToRegister(User userToRegister) {
        this.userToRegister = userToRegister;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
}
