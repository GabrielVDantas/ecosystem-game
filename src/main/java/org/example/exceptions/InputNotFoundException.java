package org.example.exceptions;

public class InputNotFoundException extends RuntimeException {

    public InputNotFoundException(String pattern) {
        super("Não foi encontrado um Input para o seguinte pattern: " + pattern);
    }
}
