package com.company;

import java.util.ArrayList;

public class GateRegister implements ICardFinder {
    private ArrayList<CardBase>  cardsList = new ArrayList<>();

    public CardBase getCardById(int id)
    {
        CardBase result = null;

        for (CardBase card : cardsList) {
            if(card.getId() == id)
            {
                result = card;
                break;
            }
        }

        return result;
    }

    public CountCard createCountCard(int count){
        CountCard card = new CountCard(count);
        cardsList.add(card);
        return card;
    }

}
