package ru.neoflex.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import ru.neoflex.mvc.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
