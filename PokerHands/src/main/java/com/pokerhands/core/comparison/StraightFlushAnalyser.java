package com.pokerhands.core.comparison;

import java.util.ArrayList;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class StraightFlushAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService _handAnalyserService;

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
	HandValue retval = null;
	int value = _handAnalyserService.valueAsAStraight(hand);
	if (_handAnalyserService.isAFlush(hand) && (value >= 0)) {
	    retval = new HandValue(HandType.STRAIGHT_FLUSH, value, new ArrayList<Card>());
	}
	return retval;
    }
}
