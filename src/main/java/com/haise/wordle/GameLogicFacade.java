package com.haise.wordle;

import com.haise.wordle.DictionaryWork.DataLetters;
import com.haise.wordle.DictionaryWork.DictionaryWorker;
import com.haise.wordle.Logic.DataFiller;
import com.haise.wordle.Logic.WordConstructor;
import com.haise.wordle.constants.ConstantsString;
import com.haise.wordle.constants.ViewMessage;
import com.haise.wordle.interfaces.*;

/**
 * Класс реализующий паттерн Facade, ответственный за логическую часть игры.
 * В данном классе инициализируются классы для обработки введенного пользователем слова
 * и в методе checkWord происходит проверка данного слова.
 */
public class GameLogicFacade implements com.haise.wordle.interfaces.GameLogicFacade {
    private final SeekerInDict dictReader = new DictionaryWorker();
    private final WordBuildable constructor = new WordConstructor();
    private final DataFillable filler = new DataFiller();


    /**
     * @param userGuess  введенное пользователем слово
     * @param  listener  класс - слушатель событий, происходящих в классах реализующих интерфейс Observer
     * @param answer  загаданное слово
     * @return StringBuilder введенное пользователем слово, цвета символов которого логически обработанны
     *               Метод ответственный за проверку введенного пользователем слова
     */
    @Override
    public StringBuilder checkWord(String userGuess, GameEventListener listener, String answer) {
        if (userGuess.equalsIgnoreCase(answer)) {
            listener.fireEvent(ViewMessage.WIN_CONDITION);
        }
        if (!dictReader.find(ConstantsString.PATH_RU.getTitle(), userGuess)) {
            listener.fireEvent(ViewMessage.NOT_CONTAINS_IN_DICT);
            return new StringBuilder();
        }

        DataLetters data = new DataLetters();
        filler.fillData(data, userGuess, answer);
        return constructor.constructWord(data);

    }
}
