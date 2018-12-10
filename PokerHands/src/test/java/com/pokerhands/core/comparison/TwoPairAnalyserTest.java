package com.pokerhands.core.comparison;

import java.util.Optional;

public class TwoPairAnalyserTest extends AbstractAnalyserTest {

    @Override
    protected Class<? extends HandTypeAnalyser> getAnalyserClass() {
        return TwoPairAnalyser.class;
    }

    @Override
    protected String getWinningExample() {
        return "KSKD5H5C2S";
    }

    @Override
    protected String getLosingExample() {
        return "KHKC4D4S2H";
    }

    @Override
    protected Optional<String> getEqualWinningExample() {
        return Optional.of("KHKC5D5S2H");
    }
}