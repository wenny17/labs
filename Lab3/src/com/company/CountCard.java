package com.company;

public class CountCard extends CardBase {
    private int tripsCount;

    public CountCard(int count)
    {
        tripsCount = count;
    }

    public int getTripsCount() {
        return tripsCount;
    }

    @Override
    public boolean tryPass() {
        boolean result = tripsCount > 0;

        if(result){
            tripsCount--;
        }

        return result;
    }
}
