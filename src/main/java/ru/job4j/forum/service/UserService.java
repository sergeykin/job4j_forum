package ru.job4j.forum.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public UserService() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user1 = User.of("user1", "1");
        user1.setPassword(encoder.encode(user1.getPassword()));
        users.add(user1);
        User user2 = User.of("user2", "2");
        user2.setPassword(encoder.encode(user2.getPassword()));
        users.add(user2);
    }

    public List<User> getUsers() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }
}
