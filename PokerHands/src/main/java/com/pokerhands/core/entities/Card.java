package com.pokerhands.core.entities;

import com.pokerhands.core.enumerations.CardNumber;
import com.pokerhands.core.enumerations.CardSuit;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Card {
    private final CardNumber number;
    private final CardSuit suit;

    public Card(char numberCharacter, char suitCharacter) {
        number = CardNumber.fromCharacter(numberCharacter);
        suit = CardSuit.fromCharacter(suitCharacter);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).append(number).append(suit).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card))
            return false;
        if (obj == this)
            return true;

        Card rhs = (Card) obj;
        return new EqualsBuilder().append(number, rhs.number).append(suit, rhs.suit).isEquals();
    }

    public CardNumber getNumber() {
        return number;
    }

    public CardSuit getSuit() {
        return suit;
    }
}
