package com.pokerhands.core.comparison;

import java.util.Optional;

public class FullHouseAnalyserTest extends AbstractAnalyserTest {

    @Override
    protected Class<? extends HandTypeAnalyser> getAnalyserClass() {
        return FullHouseAnalyser.class;
    }

    @Override
    protected String getWinningExample() {
        return "KSKDKH7C7S";
    }

    @Override
    protected String getLosingExample() {
        return "QHQSQC7S7D";
    }

    @Override
    protected Optional<String> getEqualWinningExample() {
        return Optional.empty();
    }
}