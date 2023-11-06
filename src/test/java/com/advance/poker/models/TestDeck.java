package com.advance.poker.models;

import com.advance.poker.interfaces.Game;

import java.util.List;

public class TestDeck extends PokerDeck {
    public TestDeck(Game game) {
        super(game);
    }

    // Expose the cards for testing purposes
    public List<Card> getCards() {
        return super.cards;
    }
}

