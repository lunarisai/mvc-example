package ru.neoflex.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.neoflex.mvc.exception.InternalServerException;
import ru.neoflex.mvc.exception.NotFoundException;

@Controller
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public String throwNotFoundException() {
        return "error/404";
    }

    @ExceptionHandler(InternalServerException.class)
    public String throwInternalServerException() {
        return "error/500";
    }

}
