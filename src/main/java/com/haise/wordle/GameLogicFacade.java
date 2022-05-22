package com.haise.wordle;

import com.haise.wordle.DictionaryWork.*;
import com.haise.wordle.Logic.*;
import com.haise.wordle.WorkWithAnswerAndGuess.IPuzzler;
import com.haise.wordle.WorkWithAnswerAndGuess.Puzzler;

import java.util.List;

public class GameLogicFacade implements IGameLogicFacade{
    private final IDictReader dictReader = new DictionaryReader();
    private final List<String> dictionary = dictReader.read(ConstantsString.PATH_RU.getTitle());

    IPuzzler puzzler = new Puzzler();
    String answer = puzzler.riddleWord(dictionary);
    private final IDataFactory dataFactory = new DataFactory();
    private final IWordConstructor constructor = new WordConstructor();
    private final IDataFill filler = new DataFiller();
    private final IConditions conditions = new ConditionsChecker();



    @Override
    public StringBuilder checkWord(String userGuess) {
        if (conditions.isWin(userGuess, answer)){
            System.out.println(ConstantsString.WIN_CONDITION.getTitle());
            System.exit(0);
        }
        if (!conditions.isContains(dictionary,userGuess)){
            System.out.println(ConstantsString.NOT_CONTAINS_IN_DICT.getTitle());
            return new StringBuilder();
        }

        DataLetters data = dataFactory.createData();
        filler.fillData(data, userGuess, answer);
        return constructor.constructWord(data);

    }
}
