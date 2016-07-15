package com.pokerhands.core.enumerations;

import java.util.stream.Stream;

public enum CardNumber {
    TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'), TEN('T'), JACK('J'), QUEEN(
	    'Q'), KING('K');

    private final char _character;

    CardNumber(char character) {
	_character = character;
    }

    public char getCharacter() {
	return _character;
    }

    public static CardNumber fromCharacter(char character) {
	return Stream.of(values()).filter(n -> n.getCharacter() == character).findFirst().orElse(null);
    }
}
