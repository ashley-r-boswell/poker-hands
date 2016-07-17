package com.pokerhands.core.comparison;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class TwoPairAnalyser extends GroupTypeAnalyser {

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
	HandValue retval = null;
	Set<Card> cards = new HashSet<>(hand.getCards());
	Set<Card> pair1 = takeGroup(cards, 2, c -> c.number);
	Set<Card> pair2 = takeGroup(cards, 2, c -> c.number);
	if ((pair1 != null) && (pair2 != null)) {
	    List<Integer> numbers = new ArrayList<>();
	    numbers.add(pair1.iterator().next().number.ordinal());
	    numbers.add(pair2.iterator().next().number.ordinal());
	    int value = numbers.stream().max(Integer::compare).orElse(0) * 100;
	    value += numbers.stream().min(Integer::compare).orElse(0);
	    retval = new HandValue(HandType.TWO_PAIRS, value, cards);
	}
	return retval;
    }

}
