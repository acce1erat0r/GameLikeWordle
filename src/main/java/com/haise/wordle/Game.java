package com.haise.wordle;

import com.haise.wordle.WorkWithAnswerAndGuess.IWriter;
import com.haise.wordle.WorkWithAnswerAndGuess.WordWriter;
import com.haise.wordle.constants.ConstantsString;
import com.haise.wordle.interfaces.IGame;
import com.haise.wordle.interfaces.IGameLogicFacade;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
    //TODO:Отделить логику от вью. Создать класс который будет предавать сигналы с логической стороны вьюшке и наоборот

    private final IWriter writer = new WordWriter();
    IGameLogicFacade gameLogicFacade = new GameLogicFacade();
    private static int counter = 0;
    private final List<StringBuilder> trys = new ArrayList<>();
    @Override
    public void goGame() {
        System.out.println(ConstantsString.GREETINGS.getTitle());
        while (counter < 6){
            System.out.println(ConstantsString.WRITE_WORD.getTitle());
            String userGuess = writer.write();
            trys.add(gameLogicFacade.checkWord(userGuess));
            trys.forEach(System.out::println);
            counter++;

        }
        System.out.println(ConstantsString.LOSE_MESSAGE.getTitle());
        //TODO: добавить вывод загаданного слова, если игрок проиграл
    }
}
