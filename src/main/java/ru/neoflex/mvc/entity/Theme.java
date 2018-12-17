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
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    @Size(min = 3, max = 30)
    private String title;

    @NotNull
    @Size(min = 3)
    private String description;

    public String getPrintTitle() {
        return "Title: ".concat(title);
    }

    public String getPrintDescription() {
        return "Description: ".concat(description);
    }

}
