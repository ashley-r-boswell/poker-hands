package com.pokerhands.core.comparison;

import java.util.Comparator;
import java.util.Set;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.exceptions.PokerHandComparasonException;
import com.pokerhands.core.valueobjects.HandValue;

public class PokerHandComparator implements Comparator<PokerHand> {

    @Inject
    private Set<HandTypeAnalyser> _rules;

    @Override
    public int compare(PokerHand hand1, PokerHand hand2) {
	if (hand1.getCards().stream().anyMatch(c1 -> hand2.getCards().stream().anyMatch(c2 -> c1.equals(c2)))) {
	    throw new PokerHandComparasonException("Two hands cannot have the same card in them.");
	}
	return getBestScoreForHand(hand1).compareTo(getBestScoreForHand(hand2));
    }

    private HandValue getBestScoreForHand(PokerHand hand) {
	return _rules.stream().map(r -> r.calculateHandValue(hand)).filter(v -> v != null)
		.sorted(Comparator.reverseOrder()).findFirst()
		.orElseThrow(() -> new PokerHandComparasonException("Could not calculate a score for a hand"));
    }

}
