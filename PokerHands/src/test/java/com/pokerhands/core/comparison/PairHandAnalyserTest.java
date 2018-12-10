package com.pokerhands.core.comparison;

import java.util.Optional;

public class PairHandAnalyserTest extends AbstractAnalyserTest {

    @Override
    protected Class<? extends HandTypeAnalyser> getAnalyserClass() {
        return PairHandAnalyser.class;
    }

    @Override
    protected String getWinningExample() {
        return "KSKD4H7C3S";
    }

    @Override
    protected String getLosingExample() {
        return "QHQS4C7S2H";
    }

    @Override
    protected Optional<String> getEqualWinningExample() {
        return Optional.of("KCKS4H7H3H");
    }
}