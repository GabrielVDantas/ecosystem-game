package org.example.exceptions;

public class InputIncompleteException extends RuntimeException {

    public InputIncompleteException(String input) {
        super("O seguinte input está incompleto: " + input);
    }
}
