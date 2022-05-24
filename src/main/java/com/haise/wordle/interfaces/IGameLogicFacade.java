package com.haise.wordle.interfaces;

import com.haise.wordle.GameEventListener;

public interface IGameLogicFacade {
    StringBuilder checkWord(String userGuess, GameEventListener listener, String answer);
}
