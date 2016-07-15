package com.pokerhands.enumerations;

import java.util.stream.Stream;

public enum CardSuit {
    CLUBS('C'), SPADES('S'), DIAMONDS('D'), HEARTS('H');

    private final char _character;

    CardSuit(char character) {
	_character = character;
    }

    public char getCharacter() {
	return _character;
    }

    public static CardSuit fromCharacter(char character) {
	return Stream.of(values()).filter(n -> n.getCharacter() == character).findFirst().orElse(null);
    }
}
