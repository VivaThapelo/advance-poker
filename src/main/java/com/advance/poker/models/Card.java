package com.advance.poker.models;

import com.advance.poker.enums.Rank;
import com.advance.poker.enums.Suit;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Retrieves the rank of the object.
     *
     * @return the rank of the object
     */
    public Rank getRank() {
        return rank;
    }

        /**
     * Returns the suit of the card.
     *
     * @return  the suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return         	a string representation of the object
     */
    @Override
    public String toString() {
        return rank.getName() + suit.getSymbol();
    }
}