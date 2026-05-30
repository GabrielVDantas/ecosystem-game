package org.example.inputs;

import org.example.inputs.info.Width;

import java.util.List;

public class InputService {

    private final List<Input> instances = List.of(
            new Width()
    );

    private final InputRegistry registry = new InputRegistry(instances);

    public void validateInputs(String[] inputs) {

    }
}
