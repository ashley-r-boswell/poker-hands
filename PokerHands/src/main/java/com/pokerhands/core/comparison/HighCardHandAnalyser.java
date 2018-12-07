package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.Optional;

public class HighCardHandAnalyser implements HandTypeAnalyser {

    @Override
    public Optional<HandValue> calculateHandValue(PokerHand hand) {
        return Optional.of(new HandValue(HandType.HIGH_CARD, 0, hand.getCards()));
    }

}
