package com.haise.wordle.interfaces;

import com.haise.wordle.DictionaryWork.DataLetters;

public interface IWordConstructor {
    /**
     * @param data  объект класса dataLetters, содержащий три hashmap,
     *                    в каждой из которых хранятся буквы определенного цвета
     * @return возвращает слово собранное из символов всех трех хэшмап.
     * Таким образом каждый символ будет иметь соответствующий цвет.
     */
    StringBuilder constructWord(DataLetters data);
}
