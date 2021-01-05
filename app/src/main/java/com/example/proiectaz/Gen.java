package com.example.proiectaz;

public enum Gen {
    FEMININ(1), MASCULIN(0), NONE(-1);

    public final int value;

    Gen(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }

}
