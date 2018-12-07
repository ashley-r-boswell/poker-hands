package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.CardSuit;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HandAnalyserService {

    private static final int HAND_SIZE = 5;

    public int valueAsAStraight(PokerHand hand) {
        int retval = -1;
        int[] numberValues = hand.getCards().stream().mapToInt(c -> c.number.ordinal()).sorted().toArray();
        boolean isAStraight = false;
        if (numberValues.length == HAND_SIZE) {
            isAStraight = true;
            for (int i = 0; i < numberValues.length - 1; i++) {
                if ((numberValues[i] + 1) != numberValues[i + 1]) {
                    isAStraight = false;
                }
            }
        }
        if (isAStraight) {
            retval = numberValues[numberValues.length - 1];
        }
        return retval;
    }

    public boolean isAFlush(PokerHand hand) {
        CardSuit suit = hand.getCards().iterator().next().suit;
        return hand.getCards().stream().allMatch(c -> c.suit == suit);
    }

    public HandValue calculateHandValue(PokerHand hand, HandType type, int groupSize, Function<Card, ?> groupBy) {
        HandValue retval = null;
        Set<Card> cards = new HashSet<>(hand.getCards());
        Set<Card> group = takeGroup(cards, groupSize, groupBy);
        if (group != null) {
            retval = new HandValue(type, group.iterator().next().number.ordinal(), cards);
        }
        return retval;
    }

    public Set<Card> takeGroup(Set<Card> allCards, int groupSize, Function<Card, ?> groupBy) {
        Set<Card> retval = null;
        List<Card> takenCards = allCards.stream().collect(Collectors.groupingBy(groupBy)).values().stream()
                                        .filter(g -> g.size() >= groupSize).findFirst().orElse(null);
        if (takenCards != null) {
            allCards.removeAll(takenCards);
            retval = new HashSet<>(takenCards);
        }
        return retval;
    }
}
