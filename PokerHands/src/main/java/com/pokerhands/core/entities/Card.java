package com.pokerhands.core.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.pokerhands.core.enumerations.CardNumber;
import com.pokerhands.core.enumerations.CardSuit;

public class Card {
    public CardNumber number;
    public CardSuit suit;

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

}
