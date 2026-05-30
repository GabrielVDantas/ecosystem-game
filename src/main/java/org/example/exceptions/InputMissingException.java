package org.example.exceptions;

public class InputMissingException extends RuntimeException {

    public InputMissingException(String name) {
        super("O seguinte input obrigatório está faltando: " + name);
    }
}
