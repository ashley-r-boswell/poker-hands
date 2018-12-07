package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.Optional;

public interface HandTypeAnalyser {
    /*
     * Returns Optional.empty() if the analyser cannot handle this type.
     */
    Optional<HandValue> calculateHandValue(PokerHand hand);
}
