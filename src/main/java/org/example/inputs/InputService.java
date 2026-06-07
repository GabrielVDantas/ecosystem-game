package org.example.inputs;

import org.example.exceptions.input.InputDimensionsException;
import org.example.exceptions.input.InputIncompleteException;
import org.example.exceptions.input.InputMissingException;
import org.example.inputs.info.*;

import java.util.*;

public class InputService {

    private final List<Input<?>> domain = List.of(
            new Exhibition(), new Generation(), new Height(), new Rapidity(), new Seed(), new Width()
    );

    private final InputRegistry registry = new InputRegistry(domain);

    public void validateInputs(String[] inputs) {

        for (String input : inputs) {

            if (!input.contains("=") && input.split("=").length != 2) throw new InputIncompleteException(input);

            String[] itens = input.split("=");
            String pattern = itens[0].toLowerCase(), value = itens[1].toLowerCase();

            Input<?> relatedInput = this.registry.getInputBasedOnPattern(pattern);

            relatedInput.validateInputValue(value);
        }

        for (Input<?> input : this.domain) {

            if (input.isMandatory() && input.getValue() == null) throw new InputMissingException(input.getName());
        }

        for (Input<?> input : this.domain) {

            if (input instanceof Seed seed) {
                Integer widthValue = (Integer) this.registry.getInput(new Width().getPattern()).getValue();

                Integer heightValue = (Integer) this.registry.getInput(new Height().getPattern()).getValue();

                if (input.getValue() != null) {
                    String seedValue = seed.getValue();

                    seed.validateDimensions(seedValue, widthValue, heightValue);
                } else {
                    Random random = new Random();

                    seed.generateSeed(random, widthValue, heightValue);
                }
            }

            if (input instanceof Exhibition exhibition && input.getValue() == null) exhibition.setValue("i");
        }
    }
}
