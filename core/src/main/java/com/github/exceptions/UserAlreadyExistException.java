package com.github.exceptions;

public class UserAlreadyExistException extends IllegalArgumentException {
    public UserAlreadyExistException() {
        super("User with such parameters already exist.");
    }
}
