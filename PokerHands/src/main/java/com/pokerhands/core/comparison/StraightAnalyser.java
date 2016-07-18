package com.pokerhands.core.comparison;

import java.util.ArrayList;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class StraightAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService _handAnalyserService;

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
	HandValue retval = null;
	int value = _handAnalyserService.valueAsAStraight(hand);
	if (value >= 0) {
	    retval = new HandValue(HandType.STRAIGHT, value, new ArrayList<Card>());
	}
	return retval;
    }

}
