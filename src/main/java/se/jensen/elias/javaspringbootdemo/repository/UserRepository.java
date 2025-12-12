package se.jensen.elias.javaspringbootdemo.repository;


import org.springframework.stereotype.Repository;
import se.jensen.elias.javaspringbootdemo.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<User> users = new ArrayList<>();

    public void saveCreatedUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
