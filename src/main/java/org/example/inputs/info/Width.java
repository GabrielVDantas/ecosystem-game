package org.example.inputs.info;

import org.example.inputs.Input;

public class Width implements Input {

    @Override
    public String getPattern() {
        return "wd";
    }

    @Override
    public String getName() {
        return "Width";
    }
}
