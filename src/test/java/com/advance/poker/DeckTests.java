package com.advance.poker;

import com.advance.poker.interfaces.Deck;
import com.advance.poker.interfaces.Game;
import com.advance.poker.enums.Rank;
import com.advance.poker.enums.Suit;
import com.advance.poker.models.Card;
import com.advance.poker.models.TestDeck;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckTests {
    private Deck deck;

    @BeforeEach
    void setUp() {
        // You should provide a mock or stub for the Game class if it's required for testing.
        // For simplicity, we'll use a simple mock here.
        Game mockGame = new Game(5) {
            @Override
            public String evaluatePlayerHand(List<Card> hand) {
                // Implement a simple evaluation logic for the mock.
                // You can replace this with a more meaningful implementation.
                return "Mock Evaluation Result";
            }

            @Override
            public int getNumberOfCards() {
                return 5; // Assuming a hand of 5 cards for testing.
            }
        };

        deck = new TestDeck(mockGame); // TestDeck is a subclass of Deck used for testing.
    }

    @Test
    void testDealHand() {
        List<Card> hand = deck.dealHand();
        assertEquals(deck.getNumberOfCards(), hand.size());
    }

    @Test
    void testEvaluatePlayerHand() {
        List<Card> hand = createSampleHand(); // Replace with your actual hand.
        String evaluationResult = deck.evaluatePlayerHand(hand);
        assertEquals("Mock Evaluation Result", evaluationResult);
    }

    // Helper method to create a sample hand for testing.
    private List<Card> createSampleHand() {
        List<Card> hand = List.of(
            new Card(Rank.ACE, Suit.SPADES),
            new Card(Rank.KING, Suit.HEARTS),
            new Card(Rank.QUEEN, Suit.DIAMONDS),
            new Card(Rank.JACK, Suit.CLUBS),
            new Card(Rank.TEN, Suit.SPADES)
        );
        return hand;
    }
}
