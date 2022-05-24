package com.haise.wordle.Logic;

import com.haise.wordle.constants.ConstantsString;
import com.haise.wordle.DictionaryWork.DataLetters;
import com.haise.wordle.interfaces.IDataFill;

/**
 * Класс отвественный за заполнение объекта класса DataLetters
 */
public class DataFiller implements IDataFill {

    private void fillGreenLetters(DataLetters data, String userGuess, String answer) {
        for (int i = 0; i < 5; i++) {
            if (userGuess.charAt(i) == answer.charAt(i)) {
                data.getGreenLetters().put(
                        i, ConstantsString.ANSI_GREEN.getTitle()
                                + userGuess.charAt(i));
            }
        }
    }

    private void fillGrayLetters(DataLetters data, String userGuess, String answer) {
        for (int i = 0; i < 5; i++) {
            if (!answer.contains(String.valueOf(userGuess.charAt(i)))) {
                data.getGrayLetters().put(
                        i, ConstantsString.ANSI_RED.getTitle()
                                + userGuess.charAt(i));
            }
        }
    }

    //TODO: повторяющиеся буквы выделяются цветом, даже если буква в ответе одна, пофиксить
    private void fillYellowLetters(DataLetters data, String userGuess, String answer) {
        for (int i = 0; i < 5; i++) {
            if (userGuess.charAt(i) != answer.charAt(i)) {
                if (answer.contains(String.valueOf(userGuess.charAt(i)))) {
                    data.getYellowLetters().put(
                            i, ConstantsString.ANSI_YELLOW.getTitle()
                                    + userGuess.charAt(i));
                }
            }
        }
    }

    /**
     * @param data - объект класса dataLetters, содержащий три hashmap,
     *                    в каждой из которых хранятся буквы определенного цвета, userGuess
     * @param userGuess - слово введенное пользователем
     * @param answer - загаданное слово
     *
     */
    @Override
    public void fillData(DataLetters data, String userGuess, String answer) {
        fillGrayLetters(data, userGuess, answer);
        fillGreenLetters(data, userGuess, answer);
        fillYellowLetters(data, userGuess, answer);
    }
}
