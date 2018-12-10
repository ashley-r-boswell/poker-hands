package com.pokerhands.core.valueobjects;

import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HandValueTest {

    private static final Card CARD = new Card('6', 'D');
    private static final Card OTHER_CARD = new Card('7', 'C');
    private static final Card THIRD_CARD = new Card('8', 'D');
    private static final List<Card> REMAINING_CARDS = Arrays.asList(CARD, OTHER_CARD);
    private static final List<Card> OTHER_REMAINING_CARD = Arrays.asList(CARD, THIRD_CARD);
    private static final List<Card> REMAINING_CARDS_DIFFERENT_ORDER = Arrays.asList(OTHER_CARD, CARD);

    @Test
    public void createHandValue() {
        new HandValue(HandType.FULL_HOUSE, 4);
    }

    @Test
    public void createHandValueWithRemainingCards() {
        new HandValue(HandType.FOUR_OF_A_KIND, 5, REMAINING_CARDS);
    }

    @Test
    public void compareTheSameValue_Equal() {
        HandValue handValue = new HandValue(HandType.FULL_HOUSE, 4);

        assertEquals(0, handValue.compareTo(handValue));
    }

    @Test
    public void compareWithDifferentTypes_Different() {
        HandValue handValue = new HandValue(HandType.FULL_HOUSE, 4);
        HandValue otherHandValue = new HandValue(HandType.THREE_OF_A_KIND, 4);

        Assert.assertNotEquals(0, handValue.compareTo(otherHandValue));
    }

    @Test
    public void compareWithDifferentTypeSpecificValues_Different() {
        HandValue handValue = new HandValue(HandType.FULL_HOUSE, 4);
        HandValue otherHandValue = new HandValue(HandType.FULL_HOUSE, 5);

        Assert.assertNotEquals(0, handValue.compareTo(otherHandValue));
    }

    @Test
    public void compareWithDifferentRemainingCards_NotEqual() {
        HandValue handValue = new HandValue(HandType.FULL_HOUSE, 4, REMAINING_CARDS);
        HandValue otherHandValue = new HandValue(HandType.FULL_HOUSE, 4, OTHER_REMAINING_CARD);

        Assert.assertNotEquals(0, handValue.compareTo(otherHandValue));
    }

    @Test
    public void compareWithRemainingCardsInDifferentOrder_Equal() {
        HandValue handValue = new HandValue(HandType.FULL_HOUSE, 4, REMAINING_CARDS);
        HandValue otherHandValue = new HandValue(HandType.FULL_HOUSE, 4, REMAINING_CARDS_DIFFERENT_ORDER);

        Assert.assertEquals(0, handValue.compareTo(otherHandValue));
    }
}