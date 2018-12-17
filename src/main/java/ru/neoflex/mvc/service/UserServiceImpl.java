package ru.neoflex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.neoflex.mvc.entity.Role;
import ru.neoflex.mvc.entity.User;
import ru.neoflex.mvc.repository.RoleRepository;
import ru.neoflex.mvc.repository.UserRepository;

import java.util.Collections;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private static final long ROLE_USER_ID = 1L;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Can't find user with username " + username);
        }
        return user;
    }

    @Override
    public User signupUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findOne(ROLE_USER_ID);
        user.setRoles(Collections.singleton(userRole));
        return userRepository.save(user);
    }
}