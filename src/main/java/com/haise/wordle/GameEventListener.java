package com.haise.wordle;

import com.haise.wordle.constants.ViewMessage;
import com.haise.wordle.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс - наблюдатель.
 * Ответственный за вызов эвентов у классов реализующих интерфейс Observer, подписанных на него
 */
public class GameEventListener {
    private final List<Observer> observers = new ArrayList<>();

    /**
     * @param observer объект имплементирующий интерфейс observer
     *                 Метод ответственен за добавление классов реализующих интерфейс Observer в список подписчиков
     *                 на события данного класса
     */
    public void addListener(Observer observer) {
        observers.add(observer);
    }

    /**
     * @param observer объект имплементирующий интерфейс observer
     * Метод ответственен, за удаление подписчиков из списка слушателей.
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * @param message  enum ViewMessage
     * Перегруженный метод ответственный за вызов событий у подписчиков с параметром message
     */
    public void fireEvent(ViewMessage message) {
        for (Observer observer : observers) {
            observer.execute(message);
        }
    }

    /**
     * @param  trys  список StringBuilder, каждый из которых являетмя хранилищем для пользовательских попыток ввода
     *              Перегруженный метод ответственный за вызов событий у подписчиков с параметром trys
     */
    public void fireEvent(List<StringBuilder> trys) {
        for (Observer observer : observers) {
            observer.execute(trys);
        }
    }

    /**
     * @param  game объект класса Playable
     *              Перегруженный метод ответственный за вызов событий у подписчиков с параметром game
     */
    public void fireEvent(Game game) {
        for (Observer observer : observers) {
            observer.execute(game);
        }
    }

    /**
     * @param answer  загаданное слово
     *               Перегруженный метод ответственный за вызов событий у подписчиков с параметром answer
     */
    public void fireEvent(String answer) {
        for (Observer observer : observers) {
            observer.execute(answer);
        }
    }


}
