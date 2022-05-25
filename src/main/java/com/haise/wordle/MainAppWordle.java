package com.haise.wordle;

import com.haise.wordle.interfaces.Playable;

/**
 * Класс Main
 */
public class MainAppWordle  {

    public static void main(String[] args) {
       Playable playable = new Game();
       playable.goGame();

    }
}

