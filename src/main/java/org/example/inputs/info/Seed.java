package org.example.inputs.info;

import org.example.exceptions.InputDomainValueException;
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
        return "0:1:2:3:4:5:6:7:8:9:#";
    }

    @Override
    public void validateInputValue(String value) {

        String[] domain = this.getDomain().split(":");

        if (Arrays.stream(domain).noneMatch(d -> d.equalsIgnoreCase(value))) throw new InputDomainValueException(this.getName());
    }
}
