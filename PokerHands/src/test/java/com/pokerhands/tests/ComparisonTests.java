package com.pokerhands.tests;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.comparison.StandardFiveCardPokerModule;

public class ComparisonTests {

    private Comparator<PokerHand> _comparator;

    @Before
    public void setUp() {
	Injector injector = Guice.createInjector(new StandardFiveCardPokerModule());
	_comparator = injector.getInstance(Key.get(new TypeLiteral<Comparator<PokerHand>>() {
	}));
    }

    @Test
    public void runAnyComparison() {
	_comparator.compare(new PokerHand("2H3C6SAHAS"), new PokerHand("3H4C5SKHKS"));
    }

}
