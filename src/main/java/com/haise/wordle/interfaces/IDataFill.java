package com.haise.wordle.interfaces;

import com.haise.wordle.DictionaryWork.DataLetters;

public interface IDataFill {
   /**
    * @param data  объект класса dataLetters, содержащий три hashmap,
    *                    в каждой из которых хранятся буквы определенного цвета, userGuess
    * @param userGuess  слово введенное пользователем
    * @param answer  загаданное слово
    *
    */
   void fillData(DataLetters data, String userGuess, String answer);
}
