package ru.neoflex.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.neoflex.mvc.entity.Theme;
import ru.neoflex.mvc.exception.InternalServerException;
import ru.neoflex.mvc.exception.NotFoundException;
import ru.neoflex.mvc.repository.ThemeRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/theme")
public class ThemeController {

    private ThemeRepository themeRepository;

    public ThemeController(ThemeRepository themeRepository) { this.themeRepository = themeRepository; }

    @GetMapping
    public String list(ModelMap model) {
        model.addAttribute("themes", themeRepository.findAll());
        return "theme/list";
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        model.addAttribute("theme", new Theme());
        return "theme/add";
    }


    @PostMapping("/add")
    public String add(@Valid Theme theme, BindingResult result) {
        if (result.hasErrors()) {
            return "theme/add";
        }

        themeRepository.save(theme);

        return "redirect:/theme/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, ModelMap model) {

        Theme theme = themeRepository.findOne(id);
        model.addAttribute("theme", theme);

        return "theme/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@Valid Theme theme, BindingResult result) {
        if (result.hasErrors()) {
            return "theme/edit";
        }

        themeRepository.save(theme);

        return "redirect:/theme/";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, ModelMap model) {

        Theme theme = themeRepository.findOne(id);

        if (id == 10)
            throw new InternalServerException();

        if (theme != null) {
            model.addAttribute("theme", theme);
            return "theme/view";
        } else {
            throw new NotFoundException();
        }
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {

        themeRepository.delete(id);
        return "redirect:/theme/";
    }

}
