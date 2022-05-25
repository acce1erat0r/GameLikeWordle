package com.haise.wordle.interfaces;

import com.haise.wordle.GameEventListener;

public interface GameLogicFacade {
    /**
     * @param userGuess  введенное пользователем слово
     * @param  listener  класс - слушатель событий, происходящих в классах реализующих интерфейс Observer
     * @param answer  загаданное слово
     * @return StringBuilder введенное пользователем слово, цвета символов которого логически обработанны
     *               Метод ответственный за проверку введенного пользователем слова
     */
    StringBuilder checkWord(String userGuess, GameEventListener listener, String answer);
}
