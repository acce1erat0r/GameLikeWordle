package com.haise.wordle.interfaces;

import com.haise.wordle.DictionaryWork.DataLetters;

public interface DataFillable {
   /**
    * @param data  объект класса dataLetters, содержащий три hashmap,
    *                    в каждой из которых хранятся буквы определенного цвета, userGuess
    * @param userGuess  слово введенное пользователем
    * @param answer  загаданное слово
    * Метод ответственен за заполнение полей класса DataLetters
    */
   void fillData(DataLetters data, String userGuess, String answer);
}
