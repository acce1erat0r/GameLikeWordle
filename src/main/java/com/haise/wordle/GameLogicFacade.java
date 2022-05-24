package com.haise.wordle;

import com.haise.wordle.DictionaryWork.DataLetters;
import com.haise.wordle.DictionaryWork.DictionaryWorker;
import com.haise.wordle.Logic.DataFiller;
import com.haise.wordle.Logic.WordConstructor;
import com.haise.wordle.constants.ConstantsString;
import com.haise.wordle.interfaces.*;

public class GameLogicFacade implements IGameLogicFacade{
    private final IFinderInDict dictReader = new DictionaryWorker();
    private final IPuzzler puzzler = new DictionaryWorker();

    String answer =  puzzler.riddleWord(ConstantsString.PATH_EN.getTitle());
    private final IWordConstructor constructor = new WordConstructor();
    private final IDataFill filler = new DataFiller();



    @Override
    public StringBuilder checkWord(String userGuess) {

        System.out.println(answer);
        if (userGuess.equalsIgnoreCase(answer)){
            //TODO: такой же сигнал для мейн цикла
            System.out.println(ConstantsString.WIN_CONDITION.getTitle());
            System.exit(0);
        }
        //TODO: тут нужен какой-либо сигнал для мейн цикла о том, чтобы перейти на некс итерацию, да и сообщения для юзера лучше вывести в отдельный класс
        if (!dictReader.find( ConstantsString.PATH_EN.getTitle(), userGuess)){
            System.out.println(ConstantsString.NOT_CONTAINS_IN_DICT.getTitle());
        }

        DataLetters data = new DataLetters();
        filler.fillData(data, userGuess, answer);
        return constructor.constructWord(data);

    }
}
