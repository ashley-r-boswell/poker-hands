package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.HashSet;
import java.util.Set;

public class FullHouseAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService handAnalyserService;

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
        Set<Card> cards = new HashSet<>(hand.getCards());
        Set<Card> theThree = handAnalyserService.takeGroup(cards, 3, Card::getNumber);
        Set<Card> theTwo = handAnalyserService.takeGroup(cards, 2, Card::getNumber);
        if ((theThree != null) && (theTwo != null)) {
            return new HandValue(HandType.FULL_HOUSE, theThree.iterator().next().getNumber().ordinal());
        }
        return null;
    }

}
