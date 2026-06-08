package org.example.inputs;

import org.example.exceptions.input.InputIncompleteException;
import org.example.inputs.info.*;

import java.util.*;

public class InputService {

    private final List<Input<?>> domain = List.of(
            new Exhibition(), new Generation(), new Height(), new Rapidity(), new Seed(), new Width()
    );

    private final InputRegistry registry = new InputRegistry(domain);

    public void validateInputs(String[] inputs) {

        for (String input : inputs) {

            if (input == null || !input.contains("=")) throw new InputIncompleteException(input);

            String[] itens = input.split("=", -1);

            if (itens.length != 2) throw new InputIncompleteException(input);

            String pattern = itens[0].toLowerCase(), value = itens[1].toLowerCase();

            Input<?> relatedInput = this.registry.getAndValidateInput(pattern);

            relatedInput.validateValue(value);
        }

        for (Input<?> input : this.domain) {
            input.validatePresence();

            input.validateInputDetails(registry);
        }
    }

    public Input<?> getInput(String pattern) {
        return this.registry.getInput(pattern);
    }
}
