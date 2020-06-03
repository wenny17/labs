package com.company;

public abstract class CardBase {
    private int id;
    private OwnerType ownerType;

    public int getId(){
        return id;
    }

    public abstract boolean tryPass();
}