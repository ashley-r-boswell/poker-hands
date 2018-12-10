package com.pokerhands.core.comparison;

import java.util.Optional;

public class StraightAnalyserTest extends AbstractAnalyserTest {

    @Override
    protected Class<? extends HandTypeAnalyser> getAnalyserClass() {
        return StraightAnalyser.class;
    }

    @Override
    protected String getWinningExample() {
        return "ASKSQDJHTC";
    }

    @Override
    protected String getLosingExample() {
        return "KHQSJCTS9H";
    }

    @Override
    protected Optional<String> getEqualWinningExample() {
        return Optional.of("AHKCQCJDTS");
    }
}