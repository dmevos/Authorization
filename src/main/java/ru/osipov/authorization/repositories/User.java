package ru.osipov.authorization.repositories;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class User {

    @NotBlank(message = "не должно быть пустым")
    private final String user;

    @NotBlank(message = "не должно быть пустым")
    @Min(3)
    private final String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return Objects.equals(user, user1.user) && Objects.equals(password, user1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }
}