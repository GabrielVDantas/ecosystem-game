package org.example.inputs.info;

import org.example.inputs.BaseInput;

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
    protected Integer parseValue(String value) {
        return Integer.parseInt(value);
    }
}
