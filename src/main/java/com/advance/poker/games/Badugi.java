package com.advance.poker.games;

import java.util.List;

import com.advance.poker.interfaces.Game;
import com.advance.poker.models.Card;

public class Badugi extends Game{

    protected Badugi() {
        super(4);
    }
    
    /**
     * Evaluates the player's hand and returns the result.
     *
     * @param  hand  the list of cards in the player's hand
     * @return       the result of the evaluation
     */
    @Override
    public String evaluatePlayerHand(List<Card> hand) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluatePlayerHand'");
    }
    
}
