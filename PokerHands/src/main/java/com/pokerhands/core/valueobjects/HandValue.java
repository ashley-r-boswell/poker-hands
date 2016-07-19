package com.pokerhands.core.valueobjects;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;

public class HandValue implements Comparable<HandValue> {
    private HandType _type;
    private int _typeSpecificValue;
    private Set<Card> _remainingCards;

    public HandValue(HandType type, int typeSpecificValue) {
	this(type, typeSpecificValue, null);
    }

    public HandValue(HandType type, int typeSpecificValue, Collection<Card> remainingCards) {
	_remainingCards = new HashSet<>();
	_type = type;
	_typeSpecificValue = typeSpecificValue;
	if (remainingCards != null) {
	    _remainingCards.addAll(remainingCards);
	}
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

	int[] myCardsSorted = _remainingCards.stream().mapToInt(c -> c.number.ordinal()).sorted().toArray();
	int[] otherCardsSorted = otherHand._remainingCards.stream().mapToInt(c -> c.number.ordinal()).sorted()
		.toArray();
	Arrays.sort(otherCardsSorted);
	for (int i = myCardsSorted.length - 1; i >= 0; i--) {
	    int comparison = myCardsSorted[i] - otherCardsSorted[i];
	    if (comparison != 0) {
		return comparison;
	    }
	}
	return 0;
    }

}
