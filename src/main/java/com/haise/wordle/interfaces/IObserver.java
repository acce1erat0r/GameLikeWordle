package com.haise.wordle.interfaces;

import com.haise.wordle.Game;
import com.haise.wordle.constants.ViewMessage;

import java.util.List;

public interface IObserver {
    void execute(ViewMessage message);
    void execute (List<StringBuilder> list);

    void  execute(Game game);
    void execute (String answer);

}
