package org.example.exceptions;

public class InputDimensionsException extends RuntimeException {

    public InputDimensionsException(int height, int width, String seed) {
        super("Os valores de Height: " +  height + ", e de Width: " + width + " não comportam a Seed: " + seed);
    }
}
