package org.example.exceptions;

public class InputDomainValueException extends RuntimeException {

    public InputDomainValueException(String input) {
        super("O seguinte Input tem um valor que não está dentro do aceitável: " + input);
    }
}
