package com.company;

import java.util.HashSet;

public abstract class Vehicle<T extends Person> {
    private final int capacity;
    private int occupiedSeats;
    private HashSet<Person> passengers = new HashSet<>();

    public Vehicle(int capacity){
        this.capacity = capacity;
        this.occupiedSeats = 0;
    }

    public int getMaxCapacity(){
        return capacity;
    }
    public int getoccupiedSeats(){
        return occupiedSeats;
    }

    public void putPassenger(T passenger){
        if(occupiedSeats == capacity)
            throw new IllegalStateException("Немає місць");
        if (!passengers.add(passenger))
            throw new IllegalStateException("Пассажир вже у транспорті");
        occupiedSeats++;
    }

    public void removePassenger(T passenger){
        if (!passengers.contains(passenger))
            throw new IllegalStateException("Пассажира немає у цьому транспорті");
        passengers.remove(passenger);
        occupiedSeats--;
    }

}
