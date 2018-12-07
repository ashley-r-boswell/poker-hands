package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class PairHandAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService _handAnalyserService;

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
        return _handAnalyserService.calculateHandValue(hand, HandType.PAIR, 2, c -> c.number);
    }

}
