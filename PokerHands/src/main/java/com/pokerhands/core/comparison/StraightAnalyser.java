package com.pokerhands.core.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class StraightAnalyser implements HandTypeAnalyser {

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
	HandValue retval = null;
	List<Integer> numberValues = hand.getCards().stream().map(c -> c.number.ordinal()).collect(Collectors.toList());
	Collections.sort(numberValues);
	boolean isAStraight = true;
	for (int i = 0; i < numberValues.size() - 1; i++) {
	    if ((numberValues.get(i) + 1) != numberValues.get(i + 1)) {
		isAStraight = false;
	    }
	}
	if (isAStraight) {
	    retval = new HandValue(HandType.STRAIGHT, numberValues.get(numberValues.size() - 1), new ArrayList<Card>());
	}
	return retval;
    }

}
