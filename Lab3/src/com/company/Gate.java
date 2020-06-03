package com.company;

public class Gate {

    private ICardFinder finder;

    public Gate(ICardFinder finder)
    {
        this.finder = finder;
    }

    public boolean CheckCard(int id){
        CardBase card = finder.getCardById(id);
        if(card != null) {
            return CheckCard(card);
        }
        else {
            return false;
        }
    }

    private boolean CheckCard(CardBase card){
        return card.tryPass();
    }
}
