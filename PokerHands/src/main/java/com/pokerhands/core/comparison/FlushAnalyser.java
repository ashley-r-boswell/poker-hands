package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class FlushAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService handAnalyserService;

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
        HandValue retval = null;
        if (handAnalyserService.isAFlush(hand)) {
            retval = new HandValue(HandType.FLUSH, 0, hand.getCards());
        }
        return retval;
    }

}
