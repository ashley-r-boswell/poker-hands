package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.CardSuit;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class FlushAnalyser implements HandTypeAnalyser {

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
	HandValue retval = null;
	CardSuit suit = hand.getCards().iterator().next().suit;
	if (hand.getCards().stream().allMatch(c -> c.suit == suit)) {
	    retval = new HandValue(HandType.FLUSH, 0, hand.getCards());
	}
	return retval;
    }

}
