package com.epam.jap.everteacher.exceptions;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String login) {
        super("User : " + login + " not found.");
    }
}
