package com.pokerhands.core.valueobjects;

import java.util.Arrays;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;

public class HandValue implements Comparable<HandValue> {
    private HandType _type;
    private int _typeSpecificValue;
    private SortedSet<Card> _remainingCards;

    public HandValue(HandType type, int typeSpecificValue, Collection<Card> remainingCards) {
	_remainingCards = new TreeSet<>(remainingCards);
	_type = type;
	_typeSpecificValue = typeSpecificValue;
    }

    @Override
    public int compareTo(HandValue otherHand) {
	if (this == otherHand) {
	    return 0;
	}
	int typeComparison = _type.compareTo(otherHand._type);
	if (typeComparison != 0) {
	    return typeComparison;
	}
	int valueComparison = _typeSpecificValue - otherHand._typeSpecificValue;
	if (valueComparison != 0) {
	    return valueComparison;
	}

	Card[] myCardsSorted = _remainingCards.toArray(new Card[5]);
	Arrays.sort(myCardsSorted);
	Card[] otherCardsSorted = otherHand._remainingCards.toArray(new Card[5]);
	Arrays.sort(otherCardsSorted);
	for (int i = myCardsSorted.length - 1; i >= 0; i--) {
	    int comparison = myCardsSorted[i].number.compareTo(otherCardsSorted[i].number);
	    if (comparison != 0) {
		return comparison;
	    }
	}
	return 0;
    }

}
