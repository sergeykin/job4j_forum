package ru.job4j.forum.control;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import java.util.ArrayList;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserService userService;
    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    public RegControl(PasswordEncoder encoder, UserService userService, InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.encoder = encoder;
        this.userService = userService;
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        for (User usertmp : userService.getUsers()) {
            if (user.getUsername().equals(usertmp.getUsername())) {
                return "reg";
            }
        }

        user.setPassword(encoder.encode(user.getPassword()));
        userService.add(user);
        inMemoryUserDetailsManager.createUser(
                org.springframework.security.core.userdetails.User
                        .withUsername(user.getUsername())
                        .password(user.getPassword())
                        .roles("USER").build());
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }
}
