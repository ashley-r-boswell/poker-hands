package com.pokerhands.core.comparison;

import com.google.inject.Inject;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.Optional;

public class StraightAnalyser implements HandTypeAnalyser {

    @Inject
    private HandAnalyserService handAnalyserService;

    @Override
    public Optional<HandValue> calculateHandValue(PokerHand hand) {
        int value = handAnalyserService.valueAsAStraight(hand);
        return value >= 0 ? Optional.of(new HandValue(HandType.STRAIGHT, value)) : Optional.empty();
    }

}
