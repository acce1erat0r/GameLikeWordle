package com.haise.wordle.interfaces;

import com.haise.wordle.DictionaryWork.DataLetters;

public interface WordBuildable {
    /**
     * @param data - объект класса dataLetters, содержащий три hashmap,
     *                    в каждой из которых хранятся буквы определенного цвета
     * @return возвращает StringBuilder  собранный из символов всех трех хэшмап.
     * Данный метод ответственен за сборку результирующего слова из полей класса DataLetters
     */
    StringBuilder constructWord(DataLetters data);
}
