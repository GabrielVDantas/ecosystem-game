package org.example.inputs;

import org.example.exceptions.InputNotFoundException;
import org.example.inputs.info.Width;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputRegistry {

    private final Map<String, Input> inputs = new HashMap<>();

    public Input getInputBasedOnPattern(String pattern) {

        Input input = this.inputs.get(pattern);

        if (input == null) throw new InputNotFoundException("Não foi encontrado um Input para o seguinte pattern: " + pattern);

        return input;
    }

    public InputRegistry(List<Input> instances) {

        instances.forEach(input -> this.inputs.put(input.getPattern(), input));
    }
}
