package com.pokerhands.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.comparison.FlushAnalyser;
import com.pokerhands.core.comparison.FourOfAKindAnalyser;
import com.pokerhands.core.comparison.FullHouseAnalyser;
import com.pokerhands.core.comparison.HandTypeAnalyser;
import com.pokerhands.core.comparison.HighCardHandAnalyser;
import com.pokerhands.core.comparison.PairHandAnalyser;
import com.pokerhands.core.comparison.StandardFiveCardPokerModule;
import com.pokerhands.core.comparison.StraightAnalyser;
import com.pokerhands.core.comparison.StraightFlushAnalyser;
import com.pokerhands.core.comparison.ThreeOfAKindAnalyser;
import com.pokerhands.core.comparison.TwoPairAnalyser;
import com.pokerhands.core.valueobjects.HandValue;

public class SpecificAnalyserTests {

    private Injector _injector;

    @Before
    public void setUp() throws Exception {
        _injector = Guice.createInjector(new StandardFiveCardPokerModule());
    }

    private void testAnalyser(Class<? extends HandTypeAnalyser> classToTest, String ownHand, String otherHand,
                              Outcome expectedOutcome) {
        HandTypeAnalyser testSubject = _injector.getInstance(classToTest);
        HandValue ownHandValue = testSubject.calculateHandValue(new PokerHand(ownHand));
        assertNotNull("Own hand was not detected as the expected type", ownHandValue);
        HandValue otherHandValue = testSubject.calculateHandValue(new PokerHand(otherHand));
        assertNotNull("Other hand was not detected as the expected type", otherHandValue);
        int comparisonResult = ownHandValue.compareTo(otherHandValue);
        switch (expectedOutcome) {
            case DRAW:
                assertEquals(ownHand + " should draw with " + otherHand, 0, comparisonResult);
                break;
            case LOSS:
                assertTrue(ownHand + " should lose to " + otherHand, comparisonResult < 0);
                break;
            case WIN:
                assertTrue(ownHand + " should win against " + otherHand, comparisonResult > 0);
                break;
            default:
                fail("Unknown outcome type");
                break;

        }
    }

    private enum Outcome {
        WIN, DRAW, LOSS
    }

    @Test
    public void highCardDraw() {
        testAnalyser(HighCardHandAnalyser.class, "KSQD4H7C2S", "KHQS4C7S2H", Outcome.DRAW);
    }

    @Test
    public void highCardWin() {
        testAnalyser(HighCardHandAnalyser.class, "KSQD4H7C3S", "KHQS4C7S2H", Outcome.WIN);
    }

    @Test
    public void highCardLoss() {
        testAnalyser(HighCardHandAnalyser.class, "KSQD4H7C3S", "KHQS5C7S2H", Outcome.LOSS);
    }

    @Test
    public void PairDraw() {
        testAnalyser(PairHandAnalyser.class, "KCKD4H7C2S", "KHKS4C7S2H", Outcome.DRAW);
    }

    @Test
    public void PairWin() {
        testAnalyser(PairHandAnalyser.class, "KSKD4H7C3S", "QHQS4C7S2H", Outcome.WIN);
    }

    @Test
    public void PairLoss() {
        testAnalyser(PairHandAnalyser.class, "QSQD4H7C3S", "KHKS5C7S2H", Outcome.LOSS);
    }

    @Test
    public void TwoPairDraw() {
        testAnalyser(TwoPairAnalyser.class, "KSKD4H4C2S", "KHKC4D4S2H", Outcome.DRAW);
    }

    @Test
    public void TwoPairWin() {
        testAnalyser(TwoPairAnalyser.class, "KSKD5H5C2S", "KHKC4D4S2H", Outcome.WIN);
    }

    @Test
    public void TwoPairLoss() {
        testAnalyser(TwoPairAnalyser.class, "KSKD3H3C2S", "KHKC4D4S2H", Outcome.LOSS);
    }

    @Test
    public void ThreeOfAKindWin() {
        testAnalyser(ThreeOfAKindAnalyser.class, "KSKDKH7C3S", "QHQSQC7S2H", Outcome.WIN);
    }

    @Test
    public void ThreeOfAKindLoss() {
        testAnalyser(ThreeOfAKindAnalyser.class, "3S3D3H7C4S", "QHQSQC7S2H", Outcome.LOSS);
    }

    @Test
    public void StraightDraw() {
        testAnalyser(StraightAnalyser.class, "KSQDJHTC9S", "KHQSJCTS9H", Outcome.DRAW);
    }

    @Test
    public void StraightWin() {
        testAnalyser(StraightAnalyser.class, "ASKSQDJHTC", "KHQSJCTS9H", Outcome.WIN);
    }

    @Test
    public void StraightLoss() {
        testAnalyser(StraightAnalyser.class, "QDJHTC9S8C", "KHQSJCTS9H", Outcome.LOSS);
    }

    @Test
    public void FlushDraw() {
        testAnalyser(FlushAnalyser.class, "KSQS4S7S2S", "KHQH4H7H2H", Outcome.DRAW);
    }

    @Test
    public void FlushWin() {
        testAnalyser(FlushAnalyser.class, "KSQS4S7S3S", "KHQH4H7H2H", Outcome.WIN);
    }

    @Test
    public void FlushLoss() {
        testAnalyser(FlushAnalyser.class, "KSQS4S6S2S", "KHQH4H7H2H", Outcome.LOSS);
    }

    @Test
    public void FullHouseWin() {
        testAnalyser(FullHouseAnalyser.class, "KSKDKH7C7S", "QHQSQC7S7D", Outcome.WIN);
    }

    @Test
    public void FullHouseLoss() {
        testAnalyser(FullHouseAnalyser.class, "JSJDJH7C7S", "QHQSQC7S7D", Outcome.LOSS);
    }

    @Test
    public void FourOfAKindWin() {
        testAnalyser(FourOfAKindAnalyser.class, "KSKDKHKC3S", "QHQSQCQD2H", Outcome.WIN);
    }

    @Test
    public void FourOfAKindLoss() {
        testAnalyser(FourOfAKindAnalyser.class, "TSTDTHTC3S", "QHQSQCQD2H", Outcome.LOSS);
    }

    @Test
    public void StraightFlushDraw() {
        testAnalyser(StraightFlushAnalyser.class, "KSQSJSTS9S", "KHQHJHTH9H", Outcome.DRAW);
    }

    @Test
    public void StraightFlushWin() {
        testAnalyser(StraightFlushAnalyser.class, "ASKSQSJSTS", "KHQHJHTH9H", Outcome.WIN);
    }

    @Test
    public void StraightFlushLoss() {
        testAnalyser(StraightFlushAnalyser.class, "QSJSTS9S8S", "KHQHJHTH9H", Outcome.LOSS);
    }

}
