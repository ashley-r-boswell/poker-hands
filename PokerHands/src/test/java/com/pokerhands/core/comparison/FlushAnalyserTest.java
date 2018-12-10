package com.pokerhands.core.comparison;

import java.util.Optional;

public class FlushAnalyserTest extends AbstractAnalyserTest {

    @Override
    protected Class<? extends HandTypeAnalyser> getAnalyserClass() {
        return FlushAnalyser.class;
    }

    @Override
    protected String getWinningExample() {
        return "KSQS4S7S3S";
    }

    @Override
    protected String getLosingExample() {
        return "KHQH4H7H2H";
    }

    @Override
    protected Optional<String> getEqualWinningExample() {
        return Optional.of("KHQH4H7H3H");
    }
}