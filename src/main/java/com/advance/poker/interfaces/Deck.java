package com.advance.poker.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.advance.poker.enums.Rank;
import com.advance.poker.enums.Suit;
import com.advance.poker.models.Card;

public abstract class Deck {
    protected List<Card> cards;
    private List<Card> hand;
    private final Game game;

    /**
     * Constructs a new instance of the AbstractDeck class.
     * This constructor initializes the deck with a default set of cards.
     */    
    protected Deck(Game game) {
        this.game = game;
        // Create a list of cards
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Shuffles the cards in the deck.
     *
     * @param  None    This function does not take any parameters.
     * @return None    This function does not return any value.
     */
    public abstract void shuffle();

    /**
     * Retrieves the list of cards in the deck.
     *
     * @return  the list of cards in the deck
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Retrieves the number of cards in the deck.
     *
     * @return the number of cards in the deck
     */
    public int getNumberOfCards() {
        return game.numberOfCards;
    }

    /**
     * Deals a hand of cards from the deck.
     *
     * @return  a list of cards representing the dealt hand
     */
    public List<Card> dealHand() {
        hand = new ArrayList<>();
        for (int i = 0; i < this.game.getNumberOfCards(); i++) {
            hand.add(cards.remove(0));
        }
        return hand;
    }

    /**
     * Evaluates a player's hand and returns the result.
     *
     * @param  hand  the list of cards in the player's hand
     * @return       the evaluation result of the player's hand
     */
    public String evaluatePlayerHand(List<Card> hand) {
        return game.evaluatePlayerHand(hand);
    }

}
