package com.advance.poker.interfaces;

import java.util.List;

import com.advance.poker.models.Card;

public interface Evaluator {
    public String evaluateHand(List<Card> hand);
}
