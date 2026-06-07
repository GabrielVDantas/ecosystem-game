package org.example.inputs.info;

import org.example.exceptions.input.InputValueException;
import org.example.inputs.BaseInput;
import org.example.inputs.Input;

import java.util.Arrays;

public class Rapidity extends BaseInput<Integer> {

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

        this.setValue(Integer.parseInt(value));
    }
}
