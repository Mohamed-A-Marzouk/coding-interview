package org.example;

public enum Result {
    WIN("win"),
    LOSE("lose"),
    DRAW("draw");

    private String value;

    Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
