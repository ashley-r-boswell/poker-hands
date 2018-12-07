package com.pokerhands.core.valueobjects;

import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.HandType;

import java.util.*;

public class HandValue implements Comparable<HandValue> {
    private final HandType type;
    private final int typeSpecificValue;
    private final Set<Card> remainingCards;

    public HandValue(HandType type, int typeSpecificValue) {
        this(type, typeSpecificValue, Collections.emptySet());
    }

    public HandValue(HandType type, int typeSpecificValue, Collection<Card> remainingCards) {
        this.remainingCards = new HashSet<>(remainingCards);
        this.type = type;
        this.typeSpecificValue = typeSpecificValue;
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

        int[] myCardsSorted = remainingCards.stream().mapToInt(c -> c.getNumber().ordinal()).sorted().toArray();
        int[] otherCardsSorted = otherHand.remainingCards.stream().mapToInt(c -> c.getNumber().ordinal()).sorted()
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
