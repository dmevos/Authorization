package ru.osipov.authorization.exception;

import ru.osipov.authorization.repositories.User;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(User user) {
        super(user.getUser());
    }
}