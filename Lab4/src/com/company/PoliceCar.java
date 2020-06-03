package com.company;

public class PoliceCar<T extends Policeman> extends Car<T> {
    public PoliceCar() {
        super(4);
    }
    public PoliceCar(int capacity) {
        super(capacity);
    }
}
