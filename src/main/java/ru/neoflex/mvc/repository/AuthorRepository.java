package ru.neoflex.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import ru.neoflex.mvc.entity.Author;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
