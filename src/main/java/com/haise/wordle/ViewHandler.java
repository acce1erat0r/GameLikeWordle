package com.haise.wordle;

import com.haise.wordle.constants.ViewMessage;
import com.haise.wordle.interfaces.IObserver;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ViewHandler implements IObserver {
    @Override
    public void execute(ViewMessage message) {
        switch (message) {
            case LOSE_MESSAGE:
                System.out.println(ViewMessage.LOSE_MESSAGE.getMessage());
                break;
            case GREETINGS:
                System.out.println(ViewMessage.GREETINGS.getMessage());
                break;
            case NOT_CONTAINS_IN_DICT:
                System.out.println(ViewMessage.NOT_CONTAINS_IN_DICT.getMessage());
                break;
            case WRITE_WORD:
                System.out.println(ViewMessage.WRITE_WORD.getMessage());
                break;
            case WIN_CONDITION:
                System.out.println(ViewMessage.WIN_CONDITION.getMessage());
                break;

        }
    }

    @Override
    public void execute(List<StringBuilder> list) {
        list.removeIf(CharSequence::isEmpty);
        list.forEach(System.out::println);
    }

    @Override
    public void execute(Game game) {
        Scanner sc = new Scanner(System.in);
        game.setUserGuess(sc.nextLine());
    }

    @Override
    public void execute(String answer) {
        System.out.println("Right answer is: " + answer);
    }
}
