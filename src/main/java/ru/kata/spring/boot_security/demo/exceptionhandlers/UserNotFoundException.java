package ru.kata.spring.boot_security.demo.exceptionhandlers;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
