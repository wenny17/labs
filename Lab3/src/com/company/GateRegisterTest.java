package com.company;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class GateRegisterTest {

    @org.junit.jupiter.api.Test
    void getCardById() {
    }

    @org.junit.jupiter.api.Test
    void createCountCard() {
        GateRegister register = new GateRegister();

        CountCard card = register.createCountCard(5);

        Assert.assertEquals(5, card.getTripsCount());
    }

}