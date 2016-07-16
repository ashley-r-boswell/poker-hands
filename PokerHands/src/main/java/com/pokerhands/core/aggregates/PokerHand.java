package com.pokerhands.core.aggregates;

import java.util.HashSet;
import java.util.Set;

import com.pokerhands.core.entities.Card;

public class PokerHand implements Comparable<PokerHand> {

    public PokerHand(Card card1, Card card2, Card card3, Card card4, Card card5) {
	_cards = new HashSet<>();
	_cards.add(card1);
	_cards.add(card2);
	_cards.add(card3);
	_cards.add(card4);
	_cards.add(card5);
    }

    private Set<Card> _cards;

    @Override
    public int compareTo(PokerHand arg0) {
	// TODO Auto-generated method stub
	return 0;
    }

}
