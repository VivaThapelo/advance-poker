package com.advance.poker;

import com.advance.poker.enums.Rank;
import com.advance.poker.enums.Suit;
import com.advance.poker.interfaces.Game;
import com.advance.poker.models.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTests {
    private TestGame game;

    @BeforeEach
    void setUp() {
        game = new TestGame(5); // TestGame is a subclass of Game used for testing.
    }

    @Test
    void testGetNumberOfCards() {
        int numberOfCards = game.getNumberOfCards();
        assertEquals(5, numberOfCards);
    }

    @Test
    void testEvaluatePlayerHand() {
        List<Card> hand = createSampleHand(); // Replace with your actual hand.
        String evaluationResult = game.evaluatePlayerHand(hand);
        assertEquals("Mock Evaluation Result", evaluationResult);
    }

    // Helper method to create a sample hand for testing.
    private List<Card> createSampleHand() {
        // Replace with your actual hand cards.
        return List.of(
            new Card(Rank.ACE, Suit.SPADES),
            new Card(Rank.KING, Suit.HEARTS),
            new Card(Rank.QUEEN, Suit.DIAMONDS),
            new Card(Rank.JACK, Suit.CLUBS),
            new Card(Rank.TEN, Suit.SPADES)
        );
    }
}

class TestGame extends Game {
    public TestGame(int numberOfCards) {
        super(numberOfCards);
    }

    @Override
    public String evaluatePlayerHand(List<Card> hand) {
        // Implement a simple evaluation logic for the mock.
        // You can replace this with a more meaningful implementation.
        return "Mock Evaluation Result";
    }
}

