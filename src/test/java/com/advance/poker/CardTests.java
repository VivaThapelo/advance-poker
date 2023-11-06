package com.advance.poker;

import com.advance.poker.enums.Rank;
import com.advance.poker.enums.Suit;
import com.advance.poker.models.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTests {

    @Test
    void testGetRank() {
        Card card = new Card(Rank.ACE, Suit.SPADES);
        Rank rank = card.getRank();
        assertEquals(Rank.ACE, rank);
    }

    @Test
    void testGetSuit() {
        Card card = new Card(Rank.KING, Suit.HEARTS);
        Suit suit = card.getSuit();
        assertEquals(Suit.HEARTS, suit);
    }

    @Test
    void testToString() {
        Card card = new Card(Rank.QUEEN, Suit.DIAMONDS);
        String cardString = card.toString();
        assertEquals("Q♦", cardString);
    }
}

