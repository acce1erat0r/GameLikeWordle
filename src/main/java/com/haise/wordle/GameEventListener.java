package com.haise.wordle;

import com.haise.wordle.constants.ViewMessage;
import com.haise.wordle.interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class GameEventListener {
    private final List<IObserver> observers = new ArrayList<>();

    /**
     * @param observer - объект имплементирующий интерфейс observer
     */
    public void addListener(IObserver observer) {
        observers.add(observer);
    }

    /**
     * @param observer - объект имплементирующий интерфейс observer
     */
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    /**
     * @param message - enum ViewMessage
     */
    public void fireEvent(ViewMessage message) {
        for (IObserver observer : observers) {
            observer.execute(message);
        }
    }

    /**
     * @param  trys - список StringBuilder, каждый из которых являетмя хранилищем для пользовательских попыток ввода
     */
    public void fireEvent(List<StringBuilder> trys) {
        for (IObserver observer : observers) {
            observer.execute(trys);
        }
    }

    /**
     * @param  game - объект класса Game
     */
    public void fireEvent(Game game) {
        for (IObserver observer : observers) {
            observer.execute(game);
        }
    }

    /**
     * @param answer - загаданное слово
     */
    public void fireEvent(String answer) {
        for (IObserver observer : observers) {
            observer.execute(answer);
        }
    }


}
