package com.HngProject.HngProject.exception;

public class PersonCantBeBlankException extends RuntimeException{

    public PersonCantBeBlankException(String message) {
        super(message);
    }
}
