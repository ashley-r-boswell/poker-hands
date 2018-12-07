package com.pokerhands.core.enumerations;

import java.util.stream.Stream;

public enum CardSuit {
    CLUBS('C'), SPADES('S'), DIAMONDS('D'), HEARTS('H');

    private final char character;

    CardSuit(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public static CardSuit fromCharacter(char character) {
        return Stream.of(values()).filter(n -> n.getCharacter() == character).findFirst().orElse(null);
    }
}
