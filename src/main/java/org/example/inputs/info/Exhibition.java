package org.example.inputs.info;

import org.example.exceptions.input.InputValueException;
import org.example.inputs.Input;


import java.util.Arrays;

public class Exhibition implements Input {
    @Override
    public String getName() {
        return "Exhibition";
    }

    @Override
    public String getPattern() {
        return "ex";
    }

    @Override
    public boolean isMandatory() {
        return false;
    }

    @Override
    public String getDomain() {
        return "l:i:n";
    }

    @Override
    public void validateInputValue(String value) {

        String[] domain = this.getDomain().split(":");

        if (Arrays.stream(domain).noneMatch(d -> d.equals(value))) throw new InputValueException(this.getName());
    }
}
