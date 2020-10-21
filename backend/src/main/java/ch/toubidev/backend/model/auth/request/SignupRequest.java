package ch.toubidev.backend.model.auth.request;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
}
