package com.haise.wordle.interfaces;

import com.haise.wordle.GameEventListener;

public interface IGameLogicFacade {
    /**
     * @param userGuess  введенное пользователем слово
     * @param listener  класс - слушатель событий, происходящих в классах реализующих интерфейс IObserver
     * @param answer     загаданное слово
     */
    StringBuilder checkWord(String userGuess, GameEventListener listener, String answer);
}
