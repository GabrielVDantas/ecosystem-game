package org.example;

import org.example.inputs.InputService;

public class Engine {

    private final InputService inputService = new InputService();

    public Engine(String[] inputs) {

        this.inputService.validateInputs(inputs);
    }
}
