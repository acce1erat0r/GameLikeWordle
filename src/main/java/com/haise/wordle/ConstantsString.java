package com.haise.wordle;

public enum ConstantsString {
    PATH_RU("src/main/resources/dictionary_ru.txt"),
    PATH_EN("src/main/resources/dictionary_en.txt"),
    GREETINGS("Hello dear user, are welcome to wordle game!!!"),
    WRITE_WORD("Please write your suggested word for the game to begin!"),
    WIN_CONDITION("Congratulations you guessed the word correctly, you won!!!"),
    NOT_CONTAINS_IN_DICT("Unfortunately, there is no such word in the dictionary."),
    LOSE_MESSAGE("Unfortunately you are lost game, try it later"),
    ANSI_RESET("\u001B[0m"),
    ANSI_GREEN ("\u001B[32m"),
    ANSI_YELLOW ("\u001B[33m"),
    ANSI_RED ("\u001B[31m");

    private final String title;

    public String getTitle() {
        return title;
    }

    ConstantsString(String title) {
        this.title = title;
    }



}
