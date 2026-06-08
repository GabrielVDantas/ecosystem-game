package org.example.inputs;

public interface Input<T> {

    void setValue(T value);

    T getValue();

    String getName();

    String getPattern();

    boolean isMandatory();

    String getDomain();

    void validateValue(String value);

    void validateInputDetails(InputRegistry inputRegistry);

    void validatePresence();
}
