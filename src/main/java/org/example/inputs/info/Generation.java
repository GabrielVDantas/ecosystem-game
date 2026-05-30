package org.example.inputs.info;

import org.example.exceptions.InputDomainValueException;
import org.example.inputs.Input;

import java.util.Arrays;

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
        return "0:1:2:3:4:5:6:7:8:9";
    }

    @Override
    public void validateInputValue(String value) {

        String[] domain = this.getDomain().split(":");

        if (Arrays.stream(domain).noneMatch(d -> d.equalsIgnoreCase(value))) throw new InputDomainValueException(this.getName());

        int number = Integer.parseInt(value);

        int min = 1, max = 1000;

        if (number < min ||  number > max) throw new InputDomainValueException(this.getName());
    }
}
