package com.haise.wordle.Logic;

import com.haise.wordle.constants.ConstantsString;
import com.haise.wordle.DictionaryWork.DataLetters;
import com.haise.wordle.interfaces.IWordConstructor;

public class WordConstructor implements IWordConstructor {


    /**
     * @param dataLetters - объект класса dataLetters, содержащий три hashmap,
     *                    в каждой из которых хранятся буквы определенного цвета
     * @return возвращает слово собранное из символов всех трех хэшмап.
     * Таким образом каждый символ будет иметь соответствующий цвет.
     */
    @Override
    public StringBuilder constructWord(DataLetters dataLetters) {
        StringBuilder userWordle = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (dataLetters.getYellowLetters().containsKey(i)){
                userWordle.append(dataLetters.getYellowLetters().get(i));
            }
            if (dataLetters.getGreenLetters().containsKey(i)){
                userWordle.append(dataLetters.getGreenLetters().get(i));
            }
            if (dataLetters.getGrayLetters().containsKey(i)){
                userWordle.append(dataLetters.getGrayLetters().get(i));
            }
        }
        userWordle.append(ConstantsString.ANSI_RESET.getTitle());
        return userWordle;
    }
}
