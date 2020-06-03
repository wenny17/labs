package com.company;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private List<Vehicle<?>> carsInRoad = new ArrayList<>();

    public int getCountofHumans(){
        int personCount = 0;
        for (Vehicle<?> v : carsInRoad)
            personCount += v.getoccupiedSeats();
        return personCount;
    }

    public void addCarToRoad(Vehicle<?> vehicle){
        carsInRoad.add(vehicle);
    }
    public void removeCarFromRoad(Vehicle<?> vehicle){
        if(!carsInRoad.contains(vehicle))
            throw new IllegalStateException("На дорозі немає цього ТС");
        carsInRoad.remove(vehicle);
    }

    public int carsInRoad(){
        return carsInRoad.size();
    }
}
