package com.company;

public class Taxi<T extends Person> extends Car<T> {
    public Taxi(){
        super(4);
    }
}
