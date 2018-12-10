package com.pokerhands.core.aggregates;

import com.pokerhands.core.exceptions.PokerHandInitialisationException;
import org.junit.Test;

public class PokerHandTest {

    @Test
    public void parseValidHand() {
        new PokerHand("2H2C6SAHAS");
    }

    @Test(expected = PokerHandInitialisationException.class)
    public void duplicateCardsInHand() {
        new PokerHand("2H2H6SAHAS");
    }

    @Test(expected = PokerHandInitialisationException.class)
    public void shortCardString() {
        new PokerHand("2H3C6SAHA");
    }

    @Test(expected = PokerHandInitialisationException.class)
    public void invalidCardNumber() {
        new PokerHand("2H3C6SAH1S");
    }

    @Test(expected = PokerHandInitialisationException.class)
    public void invalidCardSuit() {
        new PokerHand("2H3C6SAH2Y");
    }

    @Test(expected = PokerHandInitialisationException.class)
    public void tooManyCards() {
        new PokerHand("2H3C6SAHASQH");
    }
}