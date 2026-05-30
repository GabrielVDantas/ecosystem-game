package org.example.inputs;

import org.example.exceptions.InputIncompleteException;
import org.example.exceptions.InputMissingException;
import org.example.inputs.info.Generation;
import org.example.inputs.info.Height;
import org.example.inputs.info.Seed;
import org.example.inputs.info.Width;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputService {

    private final List<Input> instances = List.of(
            new Width(), new Height(), new Generation(), new Seed()
    );

    private final InputRegistry registry = new InputRegistry(instances);

    private final Map<String, String> received = new HashMap<>();

    public void validateInputs(String[] inputs) {

        for (String input : inputs) {

            if (input.length() < 4 || !input.contains("=") || input.indexOf("=") != 2) throw new InputIncompleteException(input);

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

        //this.validateMapDimensions(this.received.get(new Seed().getPattern()));
    }

    private void validateMapDimensions(String seed) {

        int width = Integer.parseInt(this.received.get(new Width().getPattern()));

        int height = Integer.parseInt(this.received.get(new Height().getPattern()));

        int equals = 0;
        for (int i = 0; i < seed.length(); i++) {
            if (seed.charAt(i) == '=') equals++;
        }


    }
}
