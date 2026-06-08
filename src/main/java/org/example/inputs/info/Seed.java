package org.example.inputs.info;

import org.example.exceptions.input.InputDimensionsException;
import org.example.exceptions.input.InputValueException;
import org.example.inputs.BaseInput;
import org.example.inputs.InputRegistry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Seed extends BaseInput<String> {

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
        return "0:1:2:3:4:5:#";
    }

    @Override
    protected String parseValue(String value) {
        return value;
    }

    @Override
    public void validateInputDetails(InputRegistry inputRegistry) {

        Integer width = inputRegistry.getInputByClass(Width.class).getValue();

        Integer height = inputRegistry.getInputByClass(Height.class).getValue();

        if (this.getValue() != null) {

            validateDimensions(this.getValue(), width, height);
        } else {
            Random random = new Random();

            setDefaultValue(random, width, height);
        }
    }

    @Override
    public void validateValue(String value) {

        String[] domain = this.getDomain().split(":");

        for (int i = 0; i < value.length(); i++) {
            String character = String.valueOf(value.charAt(i));

            if (Arrays.stream(domain).noneMatch(character::equals)) throw new InputValueException(this.getName());
        }

        this.setValue(value);
    }

    public void setDefaultValue(Random random, int width, int height) {

        String[] domain = this.getDomain().split(":");

        StringBuilder seed = new StringBuilder();

        int total = width * height + (height - 1);
        for (int i = 0; i < total; i++) {

            String character;

            if (i % height == 0) {
                character = "#";

            } else {
                int index = random.nextInt(domain.length);

                character = String.valueOf(domain[index]);
            }

            seed.append(character);
        }

        this.setValue(seed.toString());
    }

    public void validateDimensions(String seed, int width, int height) {
        int equals = (int) seed.chars().filter(c -> c == '#').count();

        if (equals + 1 > height) throw new InputDimensionsException(height, width, seed);

        int line = Arrays.stream(seed.split("#"))
                .max(Comparator.comparingInt(String::length)).orElse("").length();

        if (line > width) throw new InputDimensionsException(height, width, seed);
    }
}
