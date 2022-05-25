package com.haise.wordle;

import com.haise.wordle.constants.ViewMessage;
import com.haise.wordle.interfaces.Observer;

import java.util.List;
import java.util.Scanner;

/**
 * Класс ответственный за работу пользователя с консолью
 */
public class UserIOWorker implements Observer {
    /**
     * @param message  enum ViewMessage
     * Метод обработчик событий принимающих enum ViewMessage
     *                 Ответственен за вывод на консоль сообщений.
     */
    @Override
    public void execute(ViewMessage message) {
        switch (message) {
            case LOSE_MESSAGE -> System.out.println(ViewMessage.LOSE_MESSAGE.getMessage());
            case GREETINGS -> System.out.println(ViewMessage.GREETINGS.getMessage());
            case NOT_CONTAINS_IN_DICT -> System.out.println(ViewMessage.NOT_CONTAINS_IN_DICT.getMessage());
            case WRITE_WORD -> System.out.println(ViewMessage.WRITE_WORD.getMessage());
            case WIN_CONDITION -> System.out.println(ViewMessage.WIN_CONDITION.getMessage());
            case SHORT_WORD -> System.out.println(ViewMessage.SHORT_WORD.getMessage());
        }
    }

    /**
     * @param  trys  список StringBuilder, каждый из которых являетмя хранилищем для пользовательских попыток ввода
     *               Метод обработчик событий принимающих список пользовательских попыток и отображающий их на консоль
     */
    @Override
    public void execute(List<StringBuilder> trys) {
        trys.removeIf(CharSequence::isEmpty);
        trys.forEach(System.out::println);
    }

    /**
     * @param  game  объект класса Playable
     *               Метод обработчик событий, ответственный за пользовательский ввод
     */
    @Override
    public void execute(com.haise.wordle.Game game) {
        Scanner sc = new Scanner(System.in);
        String userWord = sc.nextLine();
        if (userWord.length() < 5){
            execute(ViewMessage.SHORT_WORD);
            execute(ViewMessage.WRITE_WORD);
            execute(game);
        }
        game.setUserGuess(userWord);
    }
    /**
     * @param answer загаданное слово
     *               Метод обработчик событий, ответственный за вывод на консоль загаданного в программе слова
     */
    @Override
    public void execute(String answer) {
        System.out.println("Right answer is: " + answer);
    }
}
