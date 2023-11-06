package com.advance.poker;

import org.junit.jupiter.api.Test;

import com.advance.poker.enums.Rank;
import com.advance.poker.enums.Suit;
import com.advance.poker.models.Card;
import com.advance.poker.models.PokerEvaluator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerEvaluatorTests {

    @Test
    public void testEvaluateStraightFlush() {
        List<Card> hand = Arrays.asList(
            new Card(Rank.TEN, Suit.SPADES),
            new Card(Rank.JACK, Suit.SPADES),
            new Card(Rank.QUEEN, Suit.SPADES),
            new Card(Rank.KING, Suit.SPADES),
            new Card(Rank.ACE, Suit.SPADES)
        );
        String result = new PokerEvaluator().evaluateHand(hand);
        assertEquals("Straight Flush", result);
    }

    @Test
    public void testEvaluateFourOfAKind() {
        List<Card> hand = Arrays.asList(
            new Card(Rank.KING, Suit.SPADES),
            new Card(Rank.KING, Suit.HEARTS),
            new Card(Rank.KING, Suit.DIAMONDS),
            new Card(Rank.KING, Suit.CLUBS),
            new Card(Rank.ACE, Suit.SPADES)
        );
        String result = new PokerEvaluator().evaluateHand(hand);
        assertEquals("Four of a Kind", result);
    }

    @Test
    public void testEvaluateFullHouse() {
        List<Card> hand = Arrays.asList(
            new Card(Rank.JACK, Suit.SPADES),
            new Card(Rank.JACK, Suit.HEARTS),
            new Card(Rank.JACK, Suit.DIAMONDS),
            new Card(Rank.QUEEN, Suit.CLUBS),
            new Card(Rank.QUEEN, Suit.SPADES)
        );
        String result = new PokerEvaluator().evaluateHand(hand);
        assertEquals("Full House", result);
    }

    @Test
    public void testEvaluateFlush() {
        List<Card> hand = Arrays.asList(
            new Card(Rank.TWO, Suit.SPADES),
            new Card(Rank.FOUR, Suit.SPADES),
            new Card(Rank.SIX, Suit.SPADES),
            new Card(Rank.EIGHT, Suit.SPADES),
            new Card(Rank.TEN, Suit.SPADES)
        );
        String result = new PokerEvaluator().evaluateHand(hand);
        assertEquals("Flush", result);
    }

    @Test
    public void testEvaluateStraight() {
        List<Card> hand = Arrays.asList(
            new Card(Rank.NINE, Suit.SPADES),
            new Card(Rank.TEN, Suit.HEARTS),
            new Card(Rank.JACK, Suit.DIAMONDS),
            new Card(Rank.QUEEN, Suit.CLUBS),
            new Card(Rank.KING, Suit.SPADES)
        );
        String result = new PokerEvaluator().evaluateHand(hand);
        assertEquals("Straight", result);
    }

    @Test
    public void testEvaluateThreeOfAKind() {
        List<Card> hand = Arrays.asList(
            new Card(Rank.EIGHT, Suit.SPADES),
            new Card(Rank.EIGHT, Suit.HEARTS),
            new Card(Rank.EIGHT, Suit.DIAMONDS),
            new Card(Rank.SEVEN, Suit.CLUBS),
            new Card(Rank.ACE, Suit.SPADES)
        );
        String result = new PokerEvaluator().evaluateHand(hand);
        assertEquals("Three of a Kind", result);
    }

    @Test
    public void testEvaluateTwoPair() {
        List<Card> hand = Arrays.asList(
            new Card(Rank.FIVE, Suit.SPADES),
            new Card(Rank.FIVE, Suit.HEARTS),
            new Card(Rank.NINE, Suit.DIAMONDS),
            new Card(Rank.NINE, Suit.CLUBS),
            new Card(Rank.ACE, Suit.SPADES)
        );
        String result = new PokerEvaluator().evaluateHand(hand);
        assertEquals("Two Pair", result);
    }

    @Test
    public void testEvaluateOnePair() {
        List<Card> hand = Arrays.asList(
            new Card(Rank.QUEEN, Suit.SPADES),
            new Card(Rank.QUEEN, Suit.HEARTS),
            new Card(Rank.SIX, Suit.DIAMONDS),
            new Card(Rank.SEVEN, Suit.CLUBS),
            new Card(Rank.ACE, Suit.SPADES)
        );
        String result = new PokerEvaluator().evaluateHand(hand);
        assertEquals("One Pair", result);
    }

    @Test
    public void testEvaluateHighCard() {
        List<Card> hand = Arrays.asList(
            new Card(Rank.ACE, Suit.SPADES),
            new Card(Rank.KING, Suit.HEARTS),
            new Card(Rank.TEN, Suit.DIAMONDS),
            new Card(Rank.FIVE, Suit.CLUBS),
            new Card(Rank.TWO, Suit.SPADES)
        );
        String result = new PokerEvaluator().evaluateHand(hand);
        assertEquals("High Card", result);
    }
}
