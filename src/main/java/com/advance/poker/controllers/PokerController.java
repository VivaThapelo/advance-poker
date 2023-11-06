package com.advance.poker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advance.poker.games.Poker;
import com.advance.poker.models.Card;
import com.advance.poker.models.PokerDeck;

@RestController("")
public class PokerController {

	final Poker poker;

	@Autowired
	PokerController(Poker poker) {
		this.poker = poker;
	}

    /**
     * Retrieves the poker view.
     *
     * @param  model  the model object for the view
     * @return        the string representation of the model object
     */
    @GetMapping("")
    public String pokerView(Model model) {
        PokerDeck deck = new PokerDeck(this.poker);
        deck.shuffle();
        List<Card> hand = deck.dealHand();


        String handRank = deck.evaluatePlayerHand(hand);

        model.addAttribute("hand", hand);
        model.addAttribute("evaluation", handRank);

        return model.toString();
    }
}
