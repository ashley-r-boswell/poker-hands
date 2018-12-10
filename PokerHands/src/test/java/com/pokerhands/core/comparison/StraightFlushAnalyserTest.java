package com.pokerhands.core.comparison;

import java.util.Optional;

public class StraightFlushAnalyserTest extends AbstractAnalyserTest {

    @Override
    protected Class<? extends HandTypeAnalyser> getAnalyserClass() {
        return StraightFlushAnalyser.class;
    }

    @Override
    protected String getWinningExample() {
        return "ASKSQSJSTS";
    }

    @Override
    protected String getLosingExample() {
        return "KHQHJHTH9H";
    }

    @Override
    protected Optional<String> getEqualWinningExample() {
        return Optional.of("AHKHQHJHTH");
    }
}