package ru.neoflex.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.neoflex.mvc.entity.Author;
import ru.neoflex.mvc.exception.InternalServerException;
import ru.neoflex.mvc.exception.NotFoundException;
import ru.neoflex.mvc.repository.AuthorRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String list(ModelMap model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "author/list";
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }


    @PostMapping("/add")
    public String add(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/add";
        }

        authorRepository.save(author);

        return "redirect:/author/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, ModelMap model) {

        Author author = authorRepository.findOne(id);
        model.addAttribute("author", author);

        return "author/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/edit";
        }

        authorRepository.save(author);

        return "redirect:/author/";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, ModelMap model) {

        Author author = authorRepository.findOne(id);

        if (id == 10)
            throw new InternalServerException();

        if (author != null) {
            model.addAttribute("author", author);
            return "author/view";
        } else {
            throw new NotFoundException();
        }
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {

        authorRepository.delete(id);
        return "redirect:/author/";
    }
}
