package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.Optional;

public class FlushAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService handAnalyserService;

    @Override
    public Optional<HandValue> calculateHandValue(PokerHand hand) {
        return handAnalyserService.isAFlush(hand) ? Optional.of(new HandValue(HandType.FLUSH, 0, hand.getCards())) : Optional
                .empty();
    }

}
