package com.haise.wordle.DictionaryWork;

import java.util.HashMap;


public class DataLetters {
    private final HashMap<Integer, String> greenLetters = new HashMap<>();
    private final HashMap<Integer, String> yellowLetters = new HashMap<>();
    private final HashMap<Integer, String> grayLetters = new HashMap<>();


    public HashMap<Integer, String> getGreenLetters() {
        return greenLetters;
    }


    public HashMap<Integer, String> getYellowLetters() {
        return yellowLetters;
    }


    public HashMap<Integer, String> getGrayLetters() {
        return grayLetters;
    }

}
