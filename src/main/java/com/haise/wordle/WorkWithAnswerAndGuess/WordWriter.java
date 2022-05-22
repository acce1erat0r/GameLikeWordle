package com.haise.wordle.WorkWithAnswerAndGuess;

import java.util.Scanner;

public class WordWriter implements IWriter {
    String userWord;
    Scanner sc = new Scanner(System.in);
    @Override
    public String write() {


        userWord = sc.nextLine();
        return userWord;
    }
}
