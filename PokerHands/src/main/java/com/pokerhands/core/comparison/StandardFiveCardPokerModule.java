package com.pokerhands.core.comparison;

import java.util.Comparator;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import com.pokerhands.core.aggregates.PokerHand;

public class StandardFiveCardPokerModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<HandTypeAnalyser> ruleBinder = Multibinder.newSetBinder(binder(), HandTypeAnalyser.class);
        ruleBinder.addBinding().to(StraightFlushAnalyser.class);
        ruleBinder.addBinding().to(FourOfAKindAnalyser.class);
        ruleBinder.addBinding().to(FullHouseAnalyser.class);
        ruleBinder.addBinding().to(FlushAnalyser.class);
        ruleBinder.addBinding().to(StraightAnalyser.class);
        ruleBinder.addBinding().to(ThreeOfAKindAnalyser.class);
        ruleBinder.addBinding().to(TwoPairAnalyser.class);
        ruleBinder.addBinding().to(PairHandAnalyser.class);
        ruleBinder.addBinding().to(HighCardHandAnalyser.class);

        bind(new TypeLiteral<Comparator<PokerHand>>() {
        }).to(PokerHandComparator.class);
    }

}
