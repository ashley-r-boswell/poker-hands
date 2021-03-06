package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FullHouseAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService handAnalyserService;

    @Override
    public Optional<HandValue> calculateHandValue(PokerHand hand) {
        Set<Card> cards = new HashSet<>(hand.getCards());
        Optional<Set<Card>> theThree = handAnalyserService.takeGroup(cards, 3, Card::getNumber);
        Optional<Set<Card>> theTwo = handAnalyserService.takeGroup(cards, 2, Card::getNumber);
        if (theThree.isPresent() && theTwo.isPresent()) {
            return Optional.of(new HandValue(HandType.FULL_HOUSE, theThree.get()
                                                                          .iterator()
                                                                          .next()
                                                                          .getNumber()
                                                                          .ordinal()));
        }
        return Optional.empty();
    }

}
