package com.advance.poker.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.advance.poker.models.Card;

@Component
public abstract class Game {
    protected int numberOfCards;

    protected Game(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    
	public abstract String evaluatePlayerHand(List<Card> hand);
}
