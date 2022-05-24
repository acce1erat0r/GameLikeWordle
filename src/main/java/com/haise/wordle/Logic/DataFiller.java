package com.haise.wordle.Logic;

import com.haise.wordle.constants.ConstantsString;
import com.haise.wordle.DictionaryWork.DataLetters;
import com.haise.wordle.interfaces.IDataFill;

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

    //TODO: повторяющиеся буквы РЕФАКТОР!
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

    @Override
    public void fillData(DataLetters data, String userGuess, String answer) {
        fillGrayLetters(data, userGuess, answer);
        fillGreenLetters(data, userGuess, answer);
        fillYellowLetters(data, userGuess, answer);
    }
}
