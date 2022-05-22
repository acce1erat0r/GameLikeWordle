package com.haise.wordle.Logic;

import java.util.List;

public interface IConditions {
    boolean isContains(List<String> dictionary, String userWord);
    boolean isWin(String userWord, String answer);
}
