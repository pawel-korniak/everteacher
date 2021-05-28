package com.epam.jap.everteacher.exceptions;

import org.pmw.tinylog.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionsHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundException() {
        Logger.info("User not found");
        return "error";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsernameNotFoundException.class)
    public String usernameNotFoundException() {
        Logger.info("UserName not found");
        return "error";
    }
}
