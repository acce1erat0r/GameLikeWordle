package com.haise.wordle;

import com.haise.wordle.interfaces.IGame;

/**
 * Класс Main
 */
public class MainAppWordle  {

    public static void main(String[] args) {
       IGame game = new Game();
       game.goGame();

    }
}

