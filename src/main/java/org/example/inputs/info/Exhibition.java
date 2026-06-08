package org.example.inputs.info;

import org.example.inputs.BaseInput;
import org.example.inputs.InputRegistry;

public class Exhibition extends BaseInput<String> {

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
    protected String parseValue(String value) {
        return value;
    }

    @Override
    public void validateInputDetails(InputRegistry inputRegistry) {
        if (this.getValue() == null) this.setValue("i");
    }
}
