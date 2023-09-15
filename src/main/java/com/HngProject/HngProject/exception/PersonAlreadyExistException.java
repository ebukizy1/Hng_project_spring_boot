package com.HngProject.HngProject.exception;

public class PersonAlreadyExistException extends RuntimeException {
    public PersonAlreadyExistException(String message) {
        super(message);
    }
}
