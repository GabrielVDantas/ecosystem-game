package org.example.inputs;

import org.example.exceptions.input.InputNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputRegistry {

    private final Map<String, Input<?>> inputsByPattern = new HashMap<>();

    private final Map<Class<?>, Input<?>> inputsByClass = new HashMap<>();

    public <E extends Input<?>> E getInputByClass(Class<E> clazz) {
        Input<?> input = this.inputsByClass.get(clazz);
        if (input == null) {
            throw new InputNotFoundException(clazz.getSimpleName());
        }

        return (E) input;
    }

    public Input<?> getInput(String pattern) {
        return this.inputsByPattern.get(pattern);
    }

    public Input<?> getAndValidateInput(String pattern) {
        Input<?> input = this.getInput(pattern);

        if (input == null) throw new InputNotFoundException(pattern);

        return input;
    }

    public InputRegistry(List<Input<?>> instances) {
        for (Input<?> input : instances) {

            this.inputsByPattern.put(input.getPattern(), input);

            this.inputsByClass.put(input.getClass(), input);
        }
    }
}
