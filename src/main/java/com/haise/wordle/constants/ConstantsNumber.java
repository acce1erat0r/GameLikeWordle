package com.haise.wordle.constants;

public enum ConstantsNumber {
    BOUND_OF_DICTIONARY(2100);

    private final int number;

    public int getNumber() {
        return number;
    }

    ConstantsNumber(int number) {
        this.number = number;
    }
}
