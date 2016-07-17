package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class PairHandAnalyser extends GroupTypeAnalyser {

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
	return calculateHandValue(hand, HandType.PAIR, 2, c -> c.number);
    }

}
