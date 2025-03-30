package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginCredential {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("errorMessage")
    private String errorMessage;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
