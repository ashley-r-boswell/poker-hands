package com.pokerhands.core.entities;

import com.pokerhands.core.enumerations.CardNumber;
import com.pokerhands.core.enumerations.CardSuit;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void parsesCorrectValues() {
        Card card = new Card('3', 'H');

        Assert.assertEquals(CardNumber.THREE, card.getNumber());
        Assert.assertEquals(CardSuit.HEARTS, card.getSuit());
    }

    @Test
    public void identicalCards_Equal() {
        Card card = new Card('3', 'H');
        Card otherCard = new Card('3', 'H');

        Assert.assertEquals(card, otherCard);
    }

    @Test
    public void sameCard_Equal() {
        Card card = new Card('3', 'H');

        Assert.assertEquals(card, card);
    }

    @Test
    public void cardWithDifferentNumber_NotEqual() {
        Card card = new Card('3', 'H');
        Card otherCard = new Card('4', 'H');

        Assert.assertNotEquals(card, otherCard);
    }

    @Test
    public void cardWithDifferentSuit_NotEqual() {
        Card card = new Card('3', 'H');
        Card otherCard = new Card('3', 'C');

        Assert.assertNotEquals(card, otherCard);
    }

    @Test
    public void otherObjectType_NotEqual() {
        Card card = new Card('3', 'H');

        Assert.assertNotEquals(card, 3);
    }
}