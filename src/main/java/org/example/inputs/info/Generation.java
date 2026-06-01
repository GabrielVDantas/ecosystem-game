package org.example.inputs.info;

import org.example.exceptions.input.InputValueException;
import org.example.inputs.Input;

public class Generation implements Input {

    @Override
    public String getName() {
        return "Generation";
    }

    @Override
    public String getPattern() {
        return "gn";
    }

    @Override
    public boolean isMandatory() {
        return true;
    }

    @Override
    public String getDomain() {
        return "1:1000";
    }

    @Override
    public void validateInputValue(String value) {

        if (!value.chars().allMatch(Character::isDigit)) throw new InputValueException(this.getName());

        String[] domain = this.getDomain().split(":");

        int number = Integer.parseInt(value);

        int min = Integer.parseInt(domain[0]), max = Integer.parseInt(domain[1]);

        if (number < min || number > max) throw new InputValueException(this.getName());
    }
}
