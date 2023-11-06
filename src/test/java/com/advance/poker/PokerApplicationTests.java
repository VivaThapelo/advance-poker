package com.advance.poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.advance.poker.enums.Rank;
import com.advance.poker.enums.Suit;
import com.advance.poker.games.Poker;
import com.advance.poker.models.Card;
import com.advance.poker.models.PokerDeck;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class PokerApplicationTests {

    @MockBean
    private PokerDeck pokerDeck;

    @SpyBean
    private Poker pokerGame;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRun() {
        // Create a sample hand of cards
        List<Card> sampleHand = List.of(
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.KING, Suit.HEARTS),
                new Card(Rank.QUEEN, Suit.DIAMONDS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.TEN, Suit.SPADES)
        );

        // Define the behavior of mocked and spied beans
        when(pokerDeck.dealHand()).thenReturn(sampleHand);
        when(pokerGame.evaluatePlayerHand(sampleHand)).thenReturn("Mocked Hand Rank");

        // Execute the run method
        PokerApplication pokerApp = new PokerApplication(pokerGame);
        pokerApp.run();
    }
}