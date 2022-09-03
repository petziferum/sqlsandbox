package com.example.sqlsandbox.product;

public enum ClassCategory {

    PLUS("Plus"),
    MINUS("Minus"),
    NEUTRAL("Neutral"),
    PLATIN("Platin");

    private String anzeigetext;
    private ClassCategory(String anzeigetext) {
    }

    public String toString() {
        return anzeigetext;
    }
}
