package com.pokerhands.core.comparison;

import com.pokerhands.core.aggregates.PokerHand;
import com.pokerhands.core.entities.Card;
import com.pokerhands.core.enumerations.CardSuit;
import com.pokerhands.core.enumerations.HandType;
import com.pokerhands.core.valueobjects.HandValue;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HandAnalyserService {

    private static final int HAND_SIZE = 5;

    public int valueAsAStraight(PokerHand hand) {
        int[] numberValues = hand.getCards().stream().mapToInt(c -> c.getNumber().ordinal()).sorted().toArray();
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
            return numberValues[numberValues.length - 1];
        }
        return -1;
    }

    public boolean isAFlush(PokerHand hand) {
        CardSuit suit = hand.getCards().iterator().next().getSuit();
        return hand.getCards().stream().allMatch(c -> c.getSuit() == suit);
    }

    public Optional<HandValue> calculateHandValue(PokerHand hand, HandType type, int groupSize, Function<Card, ?> groupBy) {
        Set<Card> cards = new HashSet<>(hand.getCards());
        return takeGroup(cards, groupSize, groupBy).map(group -> new HandValue(type, group.iterator()
                                                                                          .next()
                                                                                          .getNumber()
                                                                                          .ordinal(), cards));
    }

    public Optional<Set<Card>> takeGroup(Set<Card> allCards, int groupSize, Function<Card, ?> groupBy) {
        Optional<List<Card>> takenCards = allCards.stream().collect(Collectors.groupingBy(groupBy)).values().stream()
                                                  .filter(g -> g.size() >= groupSize).findFirst();
        takenCards.ifPresent(allCards::removeAll);
        return takenCards.map(HashSet::new);
    }
}
