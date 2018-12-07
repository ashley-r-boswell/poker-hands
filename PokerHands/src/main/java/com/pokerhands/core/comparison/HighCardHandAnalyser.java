package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class HighCardHandAnalyser implements HandTypeAnalyser {

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
        return new HandValue(HandType.HIGH_CARD, 0, hand.getCards());
    }

}
