package com.advance.poker.games;

import java.util.List;

import org.springframework.stereotype.Component;

import com.advance.poker.interfaces.Game;
import com.advance.poker.models.Card;
import com.advance.poker.models.PokerEvaluator;

@Component
public class Poker extends Game {

    public Poker() {
        super(5);
    }

    // to represent polymorphism
    public Poker(int numberOfCards) {
        super(numberOfCards);
    }

    @Override
    public String evaluatePlayerHand(List<Card> hand) {
        return new PokerEvaluator().evaluateHand(hand);
    }

}
