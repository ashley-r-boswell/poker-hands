package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.*;

public class TwoPairAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService handAnalyserService;

    @Override
    public Optional<HandValue> calculateHandValue(PokerHand hand) {
        Set<Card> cards = new HashSet<>(hand.getCards());
        Set<Card> pair1 = handAnalyserService.takeGroup(cards, 2, Card::getNumber);
        Set<Card> pair2 = handAnalyserService.takeGroup(cards, 2, Card::getNumber);
        if ((pair1 != null) && (pair2 != null)) {
            List<Integer> numbers = new ArrayList<>();
            numbers.add(pair1.iterator().next().getNumber().ordinal());
            numbers.add(pair2.iterator().next().getNumber().ordinal());
            int value = numbers.stream().max(Integer::compare).orElse(0) * 100;
            value += numbers.stream().min(Integer::compare).orElse(0);
            return Optional.of(new HandValue(HandType.TWO_PAIRS, value, cards));
        }
        return Optional.empty();
    }

}
