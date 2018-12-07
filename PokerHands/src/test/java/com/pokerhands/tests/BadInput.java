package com.pokerhands.tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.comparison.ComparisonModule;
import com.pokerhands.core.exceptions.PokerHandComparasonException;
import com.pokerhands.core.exceptions.PokerHandInitialisationException;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

public class BadInput {

    private Comparator<PokerHand> comparator;

    @Before
    public void setUp() {
        Injector injector = Guice.createInjector(new ComparisonModule());
        comparator = injector.getInstance(Key.get(new TypeLiteral<Comparator<PokerHand>>() {
        }));
    }

    @Test(expected = PokerHandComparasonException.class)
    public void duplicateCardsInComparison() {
        comparator.compare(new PokerHand("2H3C6SAHAS"), new PokerHand("2H3C6SAHAS"));
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
