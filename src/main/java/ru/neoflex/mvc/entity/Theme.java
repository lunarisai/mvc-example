package ru.neoflex.mvc.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(min = 3, max = 300)
    @Column(unique = true)
    private String description;

}
