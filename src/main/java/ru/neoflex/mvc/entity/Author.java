package ru.neoflex.mvc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 40)
    private String lastName;

    public String getFullName() {
        return firstName.concat(" ").concat(lastName);
    }

}
