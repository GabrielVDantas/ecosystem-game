package org.example.inputs;

import org.example.exceptions.input.InputMissingException;
import org.example.exceptions.input.InputValueException;

import java.util.Arrays;

public abstract class BaseInput<T> implements Input<T> {

    protected T value;

    protected abstract T parseValue(String value);

    @Override
    public void validateValue(String value) {

        String[] domain = this.getDomain().split(":");

        boolean isValid = Arrays.stream(domain).anyMatch(d -> d.equalsIgnoreCase(value));

        if (!isValid) throw new InputValueException(this.getName());

        T convertedValue = this.parseValue(value);

        this.setValue(convertedValue);
    }

    @Override
    public void validatePresence() {

        if (this.isMandatory() && this.value == null) throw new InputMissingException(this.getName());
    }

    @Override
    public void validateInputDetails(InputRegistry inputRegistry) {}

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
