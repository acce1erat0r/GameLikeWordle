package com.haise.wordle.WorkWithAnswerAndGuess;

import java.util.List;
import java.util.Random;

public class Puzzler implements IPuzzler{
    private final Random rnd = new Random();
    @Override
    public String riddleWord(List<String> dict) {
        return dict.get(rnd.nextInt(1, 2100));
    }
}
