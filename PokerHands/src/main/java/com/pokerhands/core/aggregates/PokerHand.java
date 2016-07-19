package com.pokerhands.core.aggregates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pokerhands.core.entities.Card;
import com.pokerhands.core.exceptions.PolkerHandInitialisationException;

public class PokerHand {

    private static final int NUMBER_OF_CARDS = 5;
    private Set<Card> _cards;

    public PokerHand(Card... cards) {
	initialise(Arrays.asList(cards));
    }

    public PokerHand(String cardDescription) {
	if ((cardDescription.length() % 2) != 0) {
	    throw new PolkerHandInitialisationException(
		    "Cards must be described in a pair of characters. The first character of the card is the number and the second is the suit");
	}
	cardDescription = cardDescription.toUpperCase();
	List<Card> cards = new ArrayList<>();
	for (int i = 0; (i + 1) < cardDescription.length(); i = i + 2) {
	    cards.add(new Card(cardDescription.charAt(i), cardDescription.charAt(i + 1)));
	}
	initialise(cards);
    }

    private void initialise(List<Card> cards) {
	if (cards.size() != NUMBER_OF_CARDS) {
	    throw new PolkerHandInitialisationException("A hand must contain " + NUMBER_OF_CARDS + " cards");
	}
	_cards = new HashSet<>();
	for (Card card : cards) {
	    if (!_cards.add(card)) {
		throw new PolkerHandInitialisationException(
			"Cannot have more than 1 card of the same number and suit.");
	    }
	}
    }

    public Set<Card> getCards() {
	return _cards;
    }

}
