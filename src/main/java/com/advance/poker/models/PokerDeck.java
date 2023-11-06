package com.advance.poker.models;

import java.util.Collections;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.advance.poker.interfaces.Deck;
import com.advance.poker.interfaces.Game;

@Component
public class PokerDeck extends Deck {

    public PokerDeck(Game game) {
        super(game);
    }

    /**
     * Shuffles the deck.
     *
     * @param  None    This function does not take any parameters.
     * @return None    This function does not return any value.
     */
    @Override
    public void shuffle() {
        Collections.shuffle(cards, new Random());
        System.out.println("Shuffling ... Shuffling ... Shuffling ...");
    }
}