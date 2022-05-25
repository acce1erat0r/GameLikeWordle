package com.haise.wordle.constants;

public enum ConstantsString {
    PATH_RU("src/main/resources/dictionary_ru.txt"),
    PATH_EN("src/main/resources/dictionary_en.txt"),

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
