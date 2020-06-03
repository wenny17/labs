package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountCardTest {

    @Test
    void tryPass() {
        GateRegister register = new GateRegister();
        CountCard card = register.createCountCard(5);

        boolean result = card.tryPass();
        result = card.tryPass();

        Assert.assertEquals(true, result);
        Assert.assertEquals(3, card.getTripsCount());
    }

    @Test
    void tryPass_TryMoreThanCount_Decline() {
        GateRegister register = new GateRegister();
        CountCard card = register.createCountCard(2);

        boolean result = card.tryPass();
        result = card.tryPass();
        result = card.tryPass();

        Assert.assertEquals(false, result);
        Assert.assertEquals(0, card.getTripsCount());
    }
}