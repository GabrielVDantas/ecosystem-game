package org.example.inputs.info;

import org.example.inputs.BaseInput;

public class Rapidity extends BaseInput<Integer> {

    @Override
    public String getName() {
        return "Rapidity";
    }

    @Override
    public String getPattern() {
        return "rp";
    }

    @Override
    public boolean isMandatory() {
        return true;
    }

    @Override
    public String getDomain() {
        return "100:250:500:750:1000";
    }

    @Override
    protected Integer parseValue(String value) {
        return Integer.parseInt(value);
    }
}
