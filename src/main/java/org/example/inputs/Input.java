package org.example.inputs;

public interface Input {

    String getName();

    String getPattern();

    boolean isMandatory();

    String getDomain();

    void validateInputValue(String value);
}
