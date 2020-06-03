package com.company;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @org.junit.jupiter.api.Test
    void getCountofHumans() {

        Car<Person> car1= new Car<>();
        car1.putPassenger(new Policeman("Bob", "Morton"));
        car1.putPassenger(new FireFighter("Bill", "Green"));
        car1.putPassenger(new Person("Arina", "Brew"));


        FireTruck<FireFighter> car2 = new FireTruck<>(20);
        car2.putPassenger(new FireFighter("Bob", "White"));
        car2.putPassenger(new FireFighter("Jake", "Grey"));
        FireFighter h =  new FireFighter("Bill", "Black");
        car2.putPassenger(h);
        car2.removePassenger(h);

        Bus<Person> b = new Bus<>(40);
        b.putPassenger(new Person("John", "Cavana"));
        b.putPassenger(new Person("Elon", "Musk"));
        b.putPassenger(new Person("Angela", "Black"));
        b.putPassenger(new Person("Maria", "Kot"));

        Road road = new Road();
        road.addCarToRoad(car1);
        road.addCarToRoad(car2);
        road.addCarToRoad(b);

        Assertions.assertEquals(9, road.getCountofHumans());
    }

    @org.junit.jupiter.api.Test
    void addCarToRoad() {
        Road road = new Road();

        Taxi<Person> car1 = new Taxi<>();
        PoliceCar<Policeman> car2 = new PoliceCar<>();
        FireTruck<FireFighter> car3 = new FireTruck<>(10);
        Bus<Person> car4 = new Bus<>(40);

        road.addCarToRoad(car1);
        road.addCarToRoad(car2);
        road.addCarToRoad(car3);
        road.addCarToRoad(car4);

        Assertions.assertEquals(4, road.carsInRoad());
    }

}