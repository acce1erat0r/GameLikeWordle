package com.haise.wordle;

import com.haise.wordle.constants.ViewMessage;
import com.haise.wordle.interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class GameEventListener {
    private final List<IObserver> observers = new ArrayList<>();
    public void addListener(IObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IObserver observer){
        observers.remove(observer);
    }

    public void fireEvent(ViewMessage message){
        for(IObserver observer : observers){
            observer.execute(message);
        }
    }
    public void fireEvent(List<StringBuilder> trys){
        for(IObserver observer : observers){
            observer.execute(trys);
        }
    }
    public void fireEvent(Game game){
       for (IObserver observer: observers){
           observer.execute(game);
       }
    }
    public void fireEvent(String answer){
        for (IObserver observer: observers){
            observer.execute(answer);
        }
    }



}
