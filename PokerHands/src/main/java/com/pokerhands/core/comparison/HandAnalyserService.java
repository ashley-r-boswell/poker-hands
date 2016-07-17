package com.pokerhands.core.comparison;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.CardSuit;

public class HandAnalyserService {

    public int valueAsAStraight(PokerHand hand) {
	int retval = -1;
	List<Integer> numberValues = hand.getCards().stream().map(c -> c.number.ordinal()).collect(Collectors.toList());
	Collections.sort(numberValues);
	boolean isAStraight = true;
	for (int i = 0; i < numberValues.size() - 1; i++) {
	    if ((numberValues.get(i) + 1) != numberValues.get(i + 1)) {
		isAStraight = false;
	    }
	}
	if (isAStraight) {
	    retval = numberValues.get(numberValues.size() - 1);
	}
	return retval;
    }

    public boolean isAFlush(PokerHand hand) {
	CardSuit suit = hand.getCards().iterator().next().suit;
	return hand.getCards().stream().allMatch(c -> c.suit == suit);
    }
}
