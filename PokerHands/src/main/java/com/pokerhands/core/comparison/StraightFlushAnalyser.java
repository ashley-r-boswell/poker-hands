package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.Optional;

public class StraightFlushAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService handAnalyserService;

    @Override
    public Optional<HandValue> calculateHandValue(PokerHand hand) {
        int value = handAnalyserService.valueAsAStraight(hand);
        if (handAnalyserService.isAFlush(hand) && (value >= 0)) {
            return Optional.of(new HandValue(HandType.STRAIGHT_FLUSH, value));
        }
        return Optional.empty();
    }
}
