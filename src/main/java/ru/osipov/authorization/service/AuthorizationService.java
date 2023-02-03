package ru.osipov.authorization.service;

import org.springframework.stereotype.Service;
import ru.osipov.authorization.exception.UnauthorizedUser;
import ru.osipov.authorization.repositories.Authorities;
import ru.osipov.authorization.repositories.User;
import ru.osipov.authorization.repositories.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser(user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}