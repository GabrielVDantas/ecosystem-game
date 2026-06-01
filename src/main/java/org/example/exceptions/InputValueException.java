package org.example.exceptions;

public class InputValueException extends RuntimeException {

    public InputValueException(String input) {
        super("O seguinte Input tem um valor que não está dentro do aceitável: " + input);
    }
}
