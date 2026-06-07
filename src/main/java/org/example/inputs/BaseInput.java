package org.example.inputs;

public abstract class BaseInput<T> implements Input<T> {

    protected T value;

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
