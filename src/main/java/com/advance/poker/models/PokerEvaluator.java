package com.advance.poker.models;

import java.util.*;

import com.advance.poker.enums.Rank;
import com.advance.poker.enums.Suit;
import com.advance.poker.interfaces.Evaluator;

public class PokerEvaluator implements Evaluator {

    /**
     * Evaluates a hand of cards and returns the corresponding hand type.
     *
     * @param  hand  the list of cards in the hand
     * @return       the hand type as a string
     */
    public String evaluateHand(List<Card> hand) {
        if (isStraightFlush(hand)) {
            return "Straight Flush";
        } else if (isFourOfAKind(hand)) {
            return "Four of a Kind";
        } else if (isFullHouse(hand)) {
            return "Full House";
        } else if (isFlush(hand)) {
            return "Flush";
        } else if (isStraight(hand)) {
            return "Straight";
        } else if (isThreeOfAKind(hand)) {
            return "Three of a Kind";
        } else if (isTwoPair(hand)) {
            return "Two Pair";
        } else if (isOnePair(hand)) {
            return "One Pair";
        } else if (isHighCard(hand)){
            return "High Card";
        } else {
            return "";
        }
    }

    private static boolean isStraightFlush(List<Card> hand) {
        return isStraight(hand) && isFlush(hand);
    }

    private static boolean isFourOfAKind(List<Card> hand) {
        Map<String, Integer> rankCount = countRanks(hand);
        for (Integer count : rankCount.values()) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

     /**
     * Determines if the given hand contains a full house.
     *
     * @param  hand  the list of cards representing the hand
     * @return       true if the hand contains a full house, false otherwise
     */
    private static boolean isFullHouse(List<Card> hand) {
        Map<String, Integer> rankCount = countRanks(hand);
        boolean hasThreeOfAKind = false;
        boolean hasOnePair = false;
        for (Integer count : rankCount.values()) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasOnePair = true;
            }
        }
        return hasThreeOfAKind && hasOnePair;
    }

    /**
     * Determines if the given hand of cards is a flush.
     *
     * @param  hand  the list of cards to check
     * @return       true if the hand is a flush, false otherwise
     */
    private static boolean isFlush(List<Card> hand) {
        Set<Suit> suits = new HashSet<>();
        for (Card card : hand) {
            suits.add(card.getSuit());
        }
        return suits.size() == 1;
    }

    /**
     * Determines if the given hand of cards forms a straight.
     *
     * @param  hand  the list of cards representing the hand
     * @return       true if the hand forms a straight, false otherwise
     */
    private static boolean isStraight(List<Card> hand) {
        List<Integer> rankValues = getSortedRankValues(hand);
        int minRank = rankValues.get(0);
        int maxRank = rankValues.get(4);
        return maxRank - minRank == 4 && new HashSet<>(rankValues).size() == 5;
    }

    private static boolean isThreeOfAKind(List<Card> hand) {
        Map<String, Integer> rankCount = countRanks(hand);
        for (Integer count : rankCount.values()) {
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

     /**
     * Determines if the given hand contains two pairs.
     *
     * @param  hand  the list of cards in the hand
     * @return       true if the hand contains two pairs, false otherwise
     */
    private static boolean isTwoPair(List<Card> hand) {
        Map<String, Integer> rankCount = countRanks(hand);
        int pairCount = 0;
        for (Integer count : rankCount.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    private static boolean isOnePair(List<Card> hand) {
        Map<String, Integer> rankCount = countRanks(hand);
        for (Integer count : rankCount.values()) {
            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    // create a function for high card
    private static boolean isHighCard(List<Card> hand) {
        List<Rank> highRanks = Arrays.asList(Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE);
        boolean highCardExist = hand.stream().filter(card -> highRanks.contains(card.getRank())).count() >= 1;
        if (highCardExist) {
            return true;
        }
        return false;
    }

    private static Map<String, Integer> countRanks(List<Card> hand) {
        Map<String, Integer> rankCount = new HashMap<>();
        for (Card card : hand) {
            Rank rank = card.getRank();
            rankCount.put(rank.getName(), rankCount.getOrDefault(rank.getName(), 0) + 1);
        }
        return rankCount;
    }

    /**
     * Retrieves a sorted list of rank values from a given hand of cards.
     *
     * @param  hand  the hand of cards from which to retrieve the rank values
     * @return       a sorted list of rank values
     */
    private static List<Integer> getSortedRankValues(List<Card> hand) {
        List<Integer> rankValues = new ArrayList<>();
        for (Card card : hand) {
            Rank rank = card.getRank();
            rankValues.add(rankValue(rank));
        }
        Collections.sort(rankValues);
        return rankValues;
    }

    /**
     * Returns the integer value of the given rank.
     *
     * @param  rank  the rank to get the value of
     * @return       the integer value of the rank
     */
    private static int rankValue(Rank rank) {
        switch (rank) {
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: return 10;
            case JACK: return 11;
            case QUEEN: return 12;
            case KING: return 13;
            case ACE: return 14;
            default: return 0;
        }
    }
}
