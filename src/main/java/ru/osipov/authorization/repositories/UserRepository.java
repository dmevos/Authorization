package ru.osipov.authorization.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    Map<User, List<Authorities>> userPermissions =
            Map.of(new User("Dima", "123"), List.of(Authorities.WRITE, Authorities.READ),
                    new User("Oleg", "456"), List.of(Authorities.WRITE),
                    new User("Kolya", "135"), List.of(Authorities.WRITE, Authorities.READ, Authorities.DELETE));

    public List<Authorities> getUserAuthorities(User user) {
        if (userPermissions.containsKey(user)) {
            return userPermissions.get(user);
        }
        return new ArrayList<>();
    }
}