package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class FlushAnalyser implements HandTypeAnalyser {

    private final HandAnalyserService _handAnalyserService;

    public FlushAnalyser(HandAnalyserService handAnalyserService) {
	_handAnalyserService = handAnalyserService;
    }

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
	HandValue retval = null;
	if (_handAnalyserService.isAFlush(hand)) {
	    retval = new HandValue(HandType.FLUSH, 0, hand.getCards());
	}
	return retval;
    }

}
