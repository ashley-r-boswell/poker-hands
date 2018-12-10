package com.pokerhands.core.comparison;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.valueobjects.HandValue;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractAnalyserTest {

    private Injector injector;

    @Before
    public void setUp() {
        injector = Guice.createInjector(new ComparisonModule());
    }

    protected abstract Class<? extends HandTypeAnalyser> getAnalyserClass();

    protected abstract String getWinningExample();

    protected abstract String getLosingExample();

    protected abstract Optional<String> getEqualWinningExample();

    private int compareHands(String ownHand, String otherHand) {
        HandTypeAnalyser testSubject = injector.getInstance(getAnalyserClass());
        Optional<HandValue> ownHandValue = testSubject.calculateHandValue(new PokerHand(ownHand));
        assertTrue("Own hand was not detected as the expected type", ownHandValue.isPresent());
        Optional<HandValue> otherHandValue = testSubject.calculateHandValue(new PokerHand(otherHand));
        assertTrue("Other hand was not detected as the expected type", otherHandValue.isPresent());
        return ownHandValue.get().compareTo(otherHandValue.get());
    }

    @Test
    public void winsWhenOwnHandIsHigher() {
        int comparisonResult = compareHands(getWinningExample(), getLosingExample());
        assertTrue(getWinningExample() + " should win against " + getLosingExample(), comparisonResult > 0);
    }

    @Test
    public void losesWhenOtherHandIsHigher() {
        int comparisonResult = compareHands(getLosingExample(), getWinningExample());
        assertTrue(getLosingExample() + " should lose to " + getWinningExample(), comparisonResult < 0);
    }

    @Test
    public void drawsWhenHandAreEqual() {
        getEqualWinningExample().ifPresent(equalWinningHand -> {
            int comparisonResult = compareHands(equalWinningHand, getWinningExample());
            assertEquals(equalWinningHand + " should draw with " + getWinningExample(), 0, comparisonResult);
        });
    }
}