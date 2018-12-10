package com.pokerhands.core.comparison;

import java.util.Optional;

public class ThreeOfAKindAnalyserTest extends AbstractAnalyserTest {

    @Override
    protected Class<? extends HandTypeAnalyser> getAnalyserClass() {
        return ThreeOfAKindAnalyser.class;
    }

    @Override
    protected String getWinningExample() {
        return "KSKDKH7C3S";
    }

    @Override
    protected String getLosingExample() {
        return "QHQSQC7S2H";
    }

    @Override
    protected Optional<String> getEqualWinningExample() {
        return Optional.empty();
    }
}