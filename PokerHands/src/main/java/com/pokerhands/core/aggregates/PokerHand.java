package com.pokerhands.core.aggregates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pokerhands.core.entities.Card;
import com.pokerhands.core.exceptions.PokerException;

public class PokerHand {

    private Set<Card> _cards;

    public PokerHand(Card... cards) {
	initialise(Arrays.asList(cards));
    }

    public PokerHand(String cardDescription) {
	if ((cardDescription.length() % 2) != 0) {
	    throw new PolkerHandInitialisationException(
		    "Cards must be described in a pair of characters. The first character of the card is the number and the second is the suit");
	}
	List<Card> cards = new ArrayList<>();
	for (int i = 0; (i + 1) < cardDescription.length(); i = i + 2) {
	    cards.add(new Card(cardDescription.charAt(i), cardDescription.charAt(i + 1)));
	}
	initialise(cards);
    }

    private void initialise(List<Card> cards) {
	if (cards.size() > 5) {
	    throw new PolkerHandInitialisationException("There cannot be more than 5 cards");
	}
	_cards = new HashSet<>();
	for (Card card : cards) {
	    if (!_cards.add(card)) {
		throw new PolkerHandInitialisationException(
			"Cannot have more than 1 card of the same number and suit.");
		// TODO Also check for card duplication during hand comparison.
	    }
	}
    }

    public Set<Card> getCards() {
	return _cards;
    }

    public class PolkerHandInitialisationException extends PokerException {
	public PolkerHandInitialisationException(String message) {
	    super(message);
	}

	private static final long serialVersionUID = 1350885742157421509L;
    }

}
