package org.example.inputs;

import org.example.exceptions.InputDimensionsException;
import org.example.exceptions.InputIncompleteException;
import org.example.exceptions.InputMissingException;
import org.example.inputs.info.*;

import java.util.*;

public class InputService {

    private final List<Input> instances = List.of(
            new Exhibition(), new Generation(), new Height(), new Rapidity(), new Seed(), new Width()
    );

    private final InputRegistry registry = new InputRegistry(instances);

    private final Map<String, String> received = new HashMap<>();

    public void validateInputs(String[] inputs) {

        for (String input : inputs) {

            if (input.length() < 4 || input.indexOf("=") != 2) throw new InputIncompleteException(input);

            String[] itens = input.split("=");
            String pattern = itens[0].toLowerCase(), value = itens[1].toLowerCase();

            Input relatedInput = this.registry.getInputBasedOnPattern(pattern);

            relatedInput.validateInputValue(value);

            this.received.put(pattern, value);
        }

        for (Input input : this.instances) {

            String related = this.received.get(input.getPattern());

            if (input.isMandatory() && (related == null || related.isBlank())) throw new InputMissingException(input.getName());
        }

        if (this.received.get(new Seed().getPattern()) != null) {
            this.validateMapDimensions(
                    this.received.get(new Seed().getPattern()),
                    Integer.parseInt(this.received.get(new Width().getPattern())),
                    Integer.parseInt(this.received.get(new Height().getPattern()))
            );
        }
    }

    private void validateMapDimensions(String seed, int width, int height) {

        int equals = (int) seed.chars().filter(c -> c == '#').count();

        if (equals + 1 > height) throw new InputDimensionsException(height, width, seed);

        int line = Arrays.stream(seed.split("#"))
                .max(Comparator.comparingInt(String::length)).orElse("").length();

        if (line > width) throw new InputDimensionsException(height, width, seed);
    }
}
