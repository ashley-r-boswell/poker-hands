package com.pokerhands.core.valueobjects;

import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HandValue implements Comparable<HandValue> {
    private HandType type;
    private int typeSpecificValue;
    private Set<Card> remainingCards;

    public HandValue(HandType type, int typeSpecificValue) {
        this(type, typeSpecificValue, null);
    }

    public HandValue(HandType type, int typeSpecificValue, Collection<Card> remainingCards) {
        this.remainingCards = new HashSet<>();
        this.type = type;
        this.typeSpecificValue = typeSpecificValue;
        if (remainingCards != null) {
            this.remainingCards.addAll(remainingCards);
        }
    }

    @Override
    public int compareTo(HandValue otherHand) {
        if (this == otherHand) {
            return 0;
        }
        int typeComparison = type.compareTo(otherHand.type);
        if (typeComparison != 0) {
            return typeComparison;
        }
        int valueComparison = typeSpecificValue - otherHand.typeSpecificValue;
        if (valueComparison != 0) {
            return valueComparison;
        }

        int[] myCardsSorted = remainingCards.stream().mapToInt(c -> c.number.ordinal()).sorted().toArray();
        int[] otherCardsSorted = otherHand.remainingCards.stream().mapToInt(c -> c.number.ordinal()).sorted()
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
