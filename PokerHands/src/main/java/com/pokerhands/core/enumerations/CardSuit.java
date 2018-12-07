package com.pokerhands.core.enumerations;

import com.pokerhands.core.exceptions.PokerHandInitialisationException;

import java.util.stream.Stream;

public enum CardSuit {
    CLUBS('C'), SPADES('S'), DIAMONDS('D'), HEARTS('H');

    private final char character;

    CardSuit(char character) {
        this.character = character;
    }

    private char getCharacter() {
        return character;
    }

    public static CardSuit fromCharacter(char character) {
        return Stream.of(values())
                     .filter(cardSuit -> cardSuit.getCharacter() == character)
                     .findFirst()
                     .orElseThrow(() -> new PokerHandInitialisationException("Unknown suit: " + character));
    }
}
