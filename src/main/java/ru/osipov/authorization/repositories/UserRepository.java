package ru.osipov.authorization.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    Map<List<String>, List<Authorities>> userPermissions =
            Map.of(List.of("Dima", "123"), List.of(Authorities.WRITE, Authorities.READ),
                    List.of("Oleg", "456"), List.of(Authorities.WRITE),
                    List.of("Kolya", "135"), List.of(Authorities.WRITE, Authorities.READ, Authorities.DELETE));

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (userPermissions.containsKey(List.of(user, password))) {
            return userPermissions.get(List.of(user, password));
        }
        return new ArrayList<>();
    }
}