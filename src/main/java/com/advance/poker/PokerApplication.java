package com.advance.poker;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.advance.poker.games.Poker;
import com.advance.poker.models.Card;
import com.advance.poker.models.PokerDeck;

@SpringBootApplication
public class PokerApplication implements CommandLineRunner {

	final Poker poker;

	@Autowired
	PokerApplication(Poker poker) {
		this.poker = poker;
	}

	private static Logger LOG = LoggerFactory
      .getLogger(PokerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PokerApplication.class, args);
	}

	@Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");

		/**
		* Select the Poker game Type
		* It will provide the evaluatePlayerHand method
		* for this specific type of poke game
		**/
        PokerDeck deck = new PokerDeck(this.poker);
        deck.shuffle();
        List<Card> hand = deck.dealHand();

        LOG.info("Your hand: " + String.join(" ", hand.stream().map(Card::toString).toList()));
        String handRank = deck.evaluatePlayerHand(hand);
		LOG.info("You have: " + handRank);
    }

}
