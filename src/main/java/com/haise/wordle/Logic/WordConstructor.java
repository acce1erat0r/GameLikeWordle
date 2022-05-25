package com.haise.wordle.Logic;

import com.haise.wordle.constants.ConstantsString;
import com.haise.wordle.DictionaryWork.DataLetters;
import com.haise.wordle.interfaces.WordBuildable;

/**
 * Класс конструктор, реализующий логику сборки слова на основе полей класса DataLetters
 */
public class WordConstructor implements WordBuildable {


    /**
     * @param dataLetters - объект класса dataLetters, содержащий три hashmap,
     *                    в каждой из которых хранятся буквы определенного цвета
     * @return возвращает StringBuilder  собранный из символов всех трех хэшмап.
     * Данный метод ответственен за сборку результирующего слова из полей класса DataLetters
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
