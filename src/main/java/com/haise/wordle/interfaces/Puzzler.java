package com.haise.wordle.interfaces;

public interface Puzzler {
 /**
 * @param  path  (string)  путь к файлу со словарем
 * @return answer (string) рандомно выбранное из словаря слово
 * Отвественностью данного метода является: рандомно выбрать слово из файла и отдать его программе
 */
    String riddleWord(String path);
}
