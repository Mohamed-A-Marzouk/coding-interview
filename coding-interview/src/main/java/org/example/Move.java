package org.example;

public enum Move {
    ROCK("rock"),
    PAPER("paper"),
    SCISSORS("scissors");

    private String value;

    Move(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
