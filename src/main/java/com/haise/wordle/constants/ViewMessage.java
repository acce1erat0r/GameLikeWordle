package com.haise.wordle.constants;

public enum ViewMessage {
    GREETINGS("Hello dear user, are welcome to wordle game!!!"),
    WRITE_WORD("Please write your suggested word for the game to begin!"),
    WIN_CONDITION("Congratulations you guessed the word correctly, you won!!!"),
    NOT_CONTAINS_IN_DICT("Unfortunately, there is no such word in the dictionary."),
    LOSE_MESSAGE("Unfortunately you are lost game, try it later");

    private final String message;

    public String getMessage() {
        return message;
    }

    ViewMessage(String message) {
        this.message = message;
    }

}
