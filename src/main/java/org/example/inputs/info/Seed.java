package org.example.inputs.info;

import org.example.exceptions.input.InputValueException;
import org.example.inputs.Input;

import java.util.Arrays;

public class Seed implements Input {

    @Override
    public String getName() {
        return "Seed";
    }

    @Override
    public String getPattern() {
        return "se";
    }

    @Override
    public boolean isMandatory() {
        return false;
    }

    @Override
    public String getDomain() {
        return "0:1:2:3:4:5:#";
    }

    @Override
    public void validateInputValue(String value) {

        String[] domain = this.getDomain().split(":");

        for (int i = 0; i < value.length(); i++) {
            String character = String.valueOf(value.charAt(i));

            if (Arrays.stream(domain).noneMatch(character::equals)) throw new InputValueException(this.getName());
        }
    }
}
