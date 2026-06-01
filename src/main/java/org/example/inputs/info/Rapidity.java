package org.example.inputs.info;

import org.example.exceptions.InputValueException;
import org.example.inputs.Input;

import java.util.Arrays;

public class Rapidity implements Input {
    @Override
    public String getName() {
        return "Rapidity";
    }

    @Override
    public String getPattern() {
        return "rp";
    }

    @Override
    public boolean isMandatory() {
        return true;
    }

    @Override
    public String getDomain() {
        return "100:250:500:750:1000";
    }

    @Override
    public void validateInputValue(String value) {

        String[] domain = this.getDomain().split(":");

        if (Arrays.stream(domain).noneMatch(d -> d.equalsIgnoreCase(value))) throw new InputValueException(this.getName());
    }
}
