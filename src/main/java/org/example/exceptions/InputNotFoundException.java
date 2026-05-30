package org.example.exceptions;

public class InputNotFoundException extends RuntimeException {

    public InputNotFoundException(String message) {
        super(message);
    }
}
