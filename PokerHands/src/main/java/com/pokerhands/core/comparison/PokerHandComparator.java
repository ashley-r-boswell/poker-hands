package com.pokerhands.core.comparison;

import java.util.Comparator;
import java.util.Set;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.exceptions.PokerHandComparasonException;
import com.pokerhands.core.valueobjects.HandValue;

public class PokerHandComparator implements Comparator<PokerHand> {
    private final Set<HandTypeAnalyser> _rules;

    public PokerHandComparator(Set<HandTypeAnalyser> rules) {
	_rules = rules;
    }

    @Override
    public int compare(PokerHand hand1, PokerHand hand2) {
	return getBestScoreForHand(hand1).compareTo(getBestScoreForHand(hand2));
    }

    private HandValue getBestScoreForHand(PokerHand hand1) {
	return _rules.stream().map(r -> r.calculateHandValue(hand1)).filter(v -> v != null)
		.sorted(Comparator.reverseOrder()).findFirst()
		.orElseThrow(() -> new PokerHandComparasonException("Could not calculate a score for a hand"));
    }

}
