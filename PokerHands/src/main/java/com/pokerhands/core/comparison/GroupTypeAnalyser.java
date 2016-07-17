package com.pokerhands.core.comparison;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public abstract class GroupTypeAnalyser implements HandTypeAnalyser {

    @Override
    public abstract HandValue calculateHandValue(PokerHand hand);

    protected static HandValue calculateHandValue(PokerHand hand, HandType type, int groupSize,
	    Function<Card, ?> groupBy) {
	HandValue retval = null;
	Set<Card> cards = new HashSet<>(hand.getCards());
	Set<Card> pair = takeGroup(cards, groupSize, groupBy);
	if (pair != null) {
	    retval = new HandValue(type, pair.iterator().next().number.ordinal(), cards);
	}
	return retval;
    }

    protected static Set<Card> takeGroup(Set<Card> allCards, int groupSize, Function<Card, ?> groupBy) {
	List<Card> retval = allCards.stream().collect(Collectors.groupingBy(groupBy)).values().stream()
		.filter(g -> g.size() >= groupSize).findFirst().orElse(null);
	if (retval != null) {
	    allCards.removeAll(retval);
	}
	return new HashSet<>(retval);
    }

}
