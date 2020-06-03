package com.company;

public class FireTruck<T extends FireFighter> extends Car<T> {

    public FireTruck(int capacity) {
        super(capacity);
    }
}
