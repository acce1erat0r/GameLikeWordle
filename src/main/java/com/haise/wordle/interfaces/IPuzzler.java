package com.haise.wordle.interfaces;

import java.util.List;

public interface IPuzzler {
    /**
     * @param  path  (string) абсолютный путь к файлу со словарем
     * @return answer (string) рандомно выбранное из словаря слово
     */
    String riddleWord(String path);
}
