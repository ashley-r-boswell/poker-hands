package com.pokerhands.tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    @Test
    public void compareOrderedListOfHands() {
	List<String> handDescriptions = Arrays.asList("TC6D3D8H7C", "JCJH3CAH7D", "4C4SKCKH3H", "QCQSQH2C5C",
		"4H5D6S7S8C", "3S8SKS5SJS", "2S2H2DACAS", "9C9S9H9D8D", "TDJDQDKDAD");
	for (int losingHandIndex = 0; losingHandIndex < handDescriptions.size() - 1; losingHandIndex++) {
	    for (int winningHandIndex = losingHandIndex + 1; winningHandIndex < handDescriptions
		    .size(); winningHandIndex++) {
		String losingHandString = handDescriptions.get(losingHandIndex);
		String winningHandString = handDescriptions.get(winningHandIndex);
		int result = _comparator.compare(new PokerHand(losingHandString), new PokerHand(winningHandString));
		assertTrue(losingHandString + " should not beat " + winningHandString, result < 0);
	    }
	}
    }

}
