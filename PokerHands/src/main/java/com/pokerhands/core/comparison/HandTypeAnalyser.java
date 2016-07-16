package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.valueobjects.HandValue;

public interface HandTypeAnalyser {
    /*
     * Returns null if there is no match.
     */
    HandValue calculateHandValue(PokerHand hand);
}
