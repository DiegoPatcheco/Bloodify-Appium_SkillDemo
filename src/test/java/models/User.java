package models;

import com.github.javafaker.Faker;

public class User {
    private final String email;
    private final String password;

    public User() {
        final var faker = new Faker();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
