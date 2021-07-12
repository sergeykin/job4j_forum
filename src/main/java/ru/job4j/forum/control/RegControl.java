package ru.job4j.forum.control;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.AuthorityRepository;
import ru.job4j.forum.repository.UserRepository;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public RegControl(PasswordEncoder encoder, UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityRepository.findByAuthority("ROLE_USER"));
        try {
            userRepository.save(user);
            return "redirect:/login";
        } catch (DataIntegrityViolationException e) {
            return "reg";
        }
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }
}
