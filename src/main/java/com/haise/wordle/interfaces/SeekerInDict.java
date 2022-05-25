package com.haise.wordle.interfaces;

public interface SeekerInDict {
    /**
     * @param path (string)  путь к файлу со словарем
     * @param userWord - слово введенное пользователем
     * @return возвращает true, если userWord содержится в словаре по пути path
     * Ответственен за проверку наличия введенного пользователем слова в файле
     */
    boolean find(String path, String userWord);
}
