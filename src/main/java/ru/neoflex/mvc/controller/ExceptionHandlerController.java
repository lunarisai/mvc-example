package ru.neoflex.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public String throwException() {
        return "error/404";
    }

}
