package com.company;

public class Car<T extends Person> extends Vehicle<T> {
    public Car() {
        super(4);
    }
    public Car(int capacity) {
        super(capacity);
    }
}
