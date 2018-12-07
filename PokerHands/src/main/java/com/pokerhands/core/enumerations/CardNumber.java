package com.pokerhands.core.enumerations;

import com.pokerhands.core.exceptions.PokerHandInitialisationException;

import java.util.stream.Stream;

public enum CardNumber {
    TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'), TEN('T'), JACK('J'), QUEEN(
            'Q'), KING('K'), ACE('A');

    private final char character;

    CardNumber(char character) {
        this.character = character;
    }

    private char getCharacter() {
        return character;
    }

    public static CardNumber fromCharacter(char character) {
        return Stream.of(values())
                     .filter(cardNumber -> cardNumber.getCharacter() == character)
                     .findFirst()
                     .orElseThrow(() -> new PokerHandInitialisationException("Unknown cardNumber: " + character));
    }
}
