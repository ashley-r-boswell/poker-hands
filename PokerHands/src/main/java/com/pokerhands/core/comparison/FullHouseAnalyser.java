package com.pokerhands.core.comparison;

import java.util.HashSet;
import java.util.Set;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class FullHouseAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService _handAnalyserService;

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
        HandValue retval = null;
        Set<Card> cards = new HashSet<>(hand.getCards());
        Set<Card> theThree = _handAnalyserService.takeGroup(cards, 3, c -> c.number);
        Set<Card> theTwo = _handAnalyserService.takeGroup(cards, 2, c -> c.number);
        if ((theThree != null) && (theTwo != null)) {
            retval = new HandValue(HandType.FULL_HOUSE, theThree.iterator().next().number.ordinal());
        }
        return retval;
    }

}
