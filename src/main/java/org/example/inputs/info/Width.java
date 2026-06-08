package org.example.inputs.info;

import org.example.inputs.BaseInput;

public class Width extends BaseInput<Integer> {

    @Override
    public String getName() {
        return "Width";
    }

    @Override
    public String getPattern() {
        return "wd";
    }

    @Override
    public boolean isMandatory() {
        return true;
    }

    @Override
    public String getDomain() {
        return "15:20:25:50:100";
    }

    @Override
    protected Integer parseValue(String value) {
        return Integer.parseInt(value);
    }
}
