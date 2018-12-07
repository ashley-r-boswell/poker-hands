package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.Optional;

public interface HandTypeAnalyser {
    /*
     * Returns null if there is no match.
     */
    Optional<HandValue> calculateHandValue(PokerHand hand);
}
