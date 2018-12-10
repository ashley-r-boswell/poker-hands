package com.pokerhands.core.comparison;

import java.util.Optional;

public class FourOfAKindAnalyserTest extends AbstractAnalyserTest {

    @Override
    protected Class<? extends HandTypeAnalyser> getAnalyserClass() {
        return FourOfAKindAnalyser.class;
    }

    @Override
    protected String getWinningExample() {
        return "KSKDKHKC3S";
    }

    @Override
    protected String getLosingExample() {
        return "QHQSQCQD2H";
    }

    @Override
    protected Optional<String> getEqualWinningExample() {
        return Optional.empty();
    }
}