package com.haise.wordle.Logic;

import java.util.List;

public class ConditionsChecker implements IConditions{
    // TODO: переработать класс так как нам больше не нужен метод isContains
    @Override
    public boolean isContains(List<String> dictionary, String userWord) {

        return dictionary.contains(userWord);
    }

    @Override
    public boolean isWin( String userWord, String answer) {
        return userWord.equals(answer);
    }
}
