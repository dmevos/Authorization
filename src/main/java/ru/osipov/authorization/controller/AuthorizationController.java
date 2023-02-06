package ru.osipov.authorization.controller;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.osipov.authorization.repositories.Authorities;
import ru.osipov.authorization.repositories.User;
import ru.osipov.authorization.service.AuthorizationService;

import java.util.List;

@Validated
@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user, BindingResult result) {
        return service.getAuthorities(user);
    }
}