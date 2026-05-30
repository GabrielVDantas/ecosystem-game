package org.example.inputs.info;

import org.example.exceptions.InputDomainValueException;
import org.example.inputs.Input;

import java.util.Arrays;

public class Height implements Input {
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
        return "[10:15:20:25:50:100]";
    }

    @Override
    public void validateInputValue(String value) {

        String[] domain = this.getDomain().split(":");

        if (Arrays.stream(domain).noneMatch(d -> d.equalsIgnoreCase(value))) throw new InputDomainValueException(this.getName());
    }
}
