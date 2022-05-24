package com.haise.wordle.interfaces;

import com.haise.wordle.Game;
import com.haise.wordle.constants.ViewMessage;

import java.util.List;

public interface IObserver {
    /**
     * @param message enum ViewMessage
     */
    void execute(ViewMessage message);
    /**
     * @param  trys  список StringBuilder, каждый из которых являетмя хранилищем для пользовательских попыток ввода
     */
    void execute (List<StringBuilder> trys);

    /**
     * @param  game  объект класса Game
     */
    void  execute(Game game);
    /**
     * @param answer загаданное слово
     */
    void execute (String answer);

}
