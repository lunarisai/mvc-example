package ru.neoflex.mvc.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.neoflex.mvc.entity.User;

public interface UserService extends UserDetailsService {
    User signupUser(User user);
}
