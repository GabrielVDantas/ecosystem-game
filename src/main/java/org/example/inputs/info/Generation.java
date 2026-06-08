package org.example.inputs.info;

import org.example.exceptions.input.InputValueException;
import org.example.inputs.BaseInput;

public class Generation extends BaseInput<Integer> {

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
    protected Integer parseValue(String value) {
        return Integer.parseInt(value);
    }

    @Override
    public void validateValue(String value) {

        if (value == null || value.isEmpty() || !value.chars().allMatch(Character::isDigit)) throw new InputValueException(this.getName());

        try {
            int number = this.parseValue(value);

            String[] domain = this.getDomain().split(":");

            int min = Integer.parseInt(domain[0]);
            int max = Integer.parseInt(domain[1]);

            if (number < min || number > max) throw new InputValueException(this.getName());

            this.setValue(number);

        } catch (NumberFormatException ex) {
            throw new InputValueException(this.getName());
        }
    }
}
