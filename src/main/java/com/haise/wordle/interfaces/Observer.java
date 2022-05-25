package com.haise.wordle.interfaces;

import com.haise.wordle.Game;
import com.haise.wordle.constants.ViewMessage;

import java.util.List;

public interface Observer {
    /**
     * @param message  enum ViewMessage
     * Метод обработчик событий принимающих enum ViewMessage
     *                 Ответственен за вывод на консоль сообщений.
     */
    void execute(ViewMessage message);
    /**
     * @param  trys  список StringBuilder, каждый из которых являетмя хранилищем для пользовательских попыток ввода
     *               Метод обработчки событий принимающих список пользовательских попыток и отображающий их на консоль
     */
    void execute (List<StringBuilder> trys);

    /**
     * @param  game  объект класса Playable
     *               Метод обработчик событий, ответственный за пользовательский ввод
     */
    void  execute(Game game);
    /**
     * @param answer загаданное слово
     *               Метод обработчик событий, ответственный за вывод на консоль загаданного в программе слова
     */
    void execute (String answer);

}
