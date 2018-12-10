package com.pokerhands.core.comparison;

import java.util.Optional;

public class HighCardHandAnalyserTest extends AbstractAnalyserTest {

    @Override
    protected Class<? extends HandTypeAnalyser> getAnalyserClass() {
        return HighCardHandAnalyser.class;
    }

    @Override
    protected String getWinningExample() {
        return "KSQD4H7C3S";
    }

    @Override
    protected String getLosingExample() {
        return "KHQS4C7S2H";
    }

    @Override
    protected Optional<String> getEqualWinningExample() {
        return Optional.of("KCQH4S7S3H");
    }

}