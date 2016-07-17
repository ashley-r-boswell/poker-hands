package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class ThreeOfAKindAnalyser extends GroupTypeAnalyser {

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
	return calculateHandValue(hand, HandType.THREE_OF_A_KIND, 3, c -> c.number);
    }

}
