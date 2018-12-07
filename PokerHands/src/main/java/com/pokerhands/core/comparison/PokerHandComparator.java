package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.exceptions.PokerHandComparasonException;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class PokerHandComparator implements Comparator<PokerHand> {

    @Inject
    private Set<HandTypeAnalyser> rules;

    @Override
    public int compare(PokerHand hand1, PokerHand hand2) {
        if (hand1.getCards().stream().anyMatch(c1 -> hand2.getCards().stream().anyMatch(c1::equals))) {
            throw new PokerHandComparasonException("Cannot compare two hands when any card from each are the same.");
        }
        return getBestScoreForHand(hand1).compareTo(getBestScoreForHand(hand2));
    }

    private HandValue getBestScoreForHand(PokerHand hand) {
        return rules.stream()
                    .map(r -> r.calculateHandValue(hand))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .min(Comparator.reverseOrder())
                    .orElseThrow(() -> new PokerHandComparasonException("Could not calculate a score for a hand"));
    }

}
