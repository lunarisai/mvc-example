package ru.neoflex.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.neoflex.mvc.entity.Author;
import ru.neoflex.mvc.entity.User;
import ru.neoflex.mvc.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class AuthController {

    private UserRepository userRepository;

    public AuthController(UserRepository userRepository) { this.userRepository = userRepository;}

    @GetMapping("/login")
    public String login(Model model) {
        return "auth/login";
    }

}
