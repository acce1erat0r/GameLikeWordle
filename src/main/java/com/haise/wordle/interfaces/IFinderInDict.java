package com.haise.wordle.interfaces;

public interface IFinderInDict {
    /**
     * @param path (string) абсолютный путь к файлу со словарем
     * @param userWord - слово введенное пользователем
     * @return возвращает true, если userWord содержится в словаре по пути path
     */
    boolean find(String path, String userWord);
}
