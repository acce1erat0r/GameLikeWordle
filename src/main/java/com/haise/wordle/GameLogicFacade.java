package com.haise.wordle;

import com.haise.wordle.DictionaryWork.DataLetters;
import com.haise.wordle.DictionaryWork.DictionaryWorker;
import com.haise.wordle.Logic.DataFiller;
import com.haise.wordle.Logic.WordConstructor;
import com.haise.wordle.constants.ConstantsString;
import com.haise.wordle.constants.ViewMessage;
import com.haise.wordle.interfaces.*;

public class GameLogicFacade implements IGameLogicFacade {
    private final IFinderInDict dictReader = new DictionaryWorker();
    private final IWordConstructor constructor = new WordConstructor();
    private final IDataFill filler = new DataFiller();


    @Override
    public StringBuilder checkWord(String userGuess, GameEventListener listener, String answer) {
        if (userGuess.equalsIgnoreCase(answer)) {
            listener.fireEvent(ViewMessage.WIN_CONDITION);
        }
        if (!dictReader.find(ConstantsString.PATH_EN.getTitle(), userGuess)) {
            listener.fireEvent(ViewMessage.NOT_CONTAINS_IN_DICT);
            return new StringBuilder();
        }

        DataLetters data = new DataLetters();
        filler.fillData(data, userGuess, answer);
        return constructor.constructWord(data);

    }
}
