package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class StraightAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService handAnalyserService;

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
        HandValue retval = null;
        int value = handAnalyserService.valueAsAStraight(hand);
        if (value >= 0) {
            retval = new HandValue(HandType.STRAIGHT, value);
        }
        return retval;
    }

}
