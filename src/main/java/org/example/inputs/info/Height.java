package org.example.inputs.info;

import org.example.exceptions.input.InputValueException;
import org.example.inputs.BaseInput;
import org.example.inputs.Input;

import java.util.Arrays;

public class Height extends BaseInput<Integer> {

    @Override
    public String getName() {
        return "Height";
    }

    @Override
    public String getPattern() {
        return "hg";
    }

    @Override
    public boolean isMandatory() {
        return true;
    }

    @Override
    public String getDomain() {
        return "10:15:20:25:50:100";
    }

    @Override
    public void validateInputValue(String value) {

        String[] domain = this.getDomain().split(":");

        if (Arrays.stream(domain).noneMatch(d -> d.equalsIgnoreCase(value))) throw new InputValueException(this.getName());

        this.setValue(Integer.parseInt(value));
    }
}
