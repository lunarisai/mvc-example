package ru.neoflex.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {
    public InternalServerException() {
        super();
    }

    public InternalServerException(String s) {
        super(s);
    }

    public InternalServerException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InternalServerException(Throwable throwable) {
        super(throwable);
    }

    protected InternalServerException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
