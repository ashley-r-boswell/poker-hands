package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.CardSuit;

public class HandAnalyserService {

    private static final int HAND_SIZE = 5;

    public int valueAsAStraight(PokerHand hand) {
	int retval = -1;
	int[] numberValues = hand.getCards().stream().mapToInt(c -> c.number.ordinal()).sorted().toArray();
	boolean isAStraight = false;
	if (numberValues.length == HAND_SIZE) {
	    isAStraight = true;
	    for (int i = 0; i < numberValues.length - 1; i++) {
		if ((numberValues[i] + 1) != numberValues[i + 1]) {
		    isAStraight = false;
		}
	    }
	}
	if (isAStraight) {
	    retval = numberValues[numberValues.length - 1];
	}
	return retval;
    }

    public boolean isAFlush(PokerHand hand) {
	CardSuit suit = hand.getCards().iterator().next().suit;
	return hand.getCards().stream().allMatch(c -> c.suit == suit);
    }
}
