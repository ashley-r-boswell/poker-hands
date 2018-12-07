package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

public class FourOfAKindAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService handAnalyserService;

    @Override
    public HandValue calculateHandValue(PokerHand hand) {
        return handAnalyserService.calculateHandValue(hand, HandType.FOUR_OF_A_KIND, 4, Card::getNumber);
    }

}
