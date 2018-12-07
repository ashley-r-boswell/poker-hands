package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.Optional;

public class PairHandAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService handAnalyserService;

    @Override
    public Optional<HandValue> calculateHandValue(PokerHand hand) {
        return handAnalyserService.calculateHandValue(hand, HandType.PAIR, 2, Card::getNumber);
    }

}
