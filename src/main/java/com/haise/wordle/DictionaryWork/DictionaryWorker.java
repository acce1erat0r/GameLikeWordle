package com.haise.wordle.DictionaryWork;

import com.haise.wordle.constants.ConstantsNumber;
import com.haise.wordle.interfaces.SeekerInDict;
import com.haise.wordle.interfaces.Puzzler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Класс ответственный за работу с файлами словарей
 */
public class DictionaryWorker implements SeekerInDict, Puzzler {
    /**
     * @param path (string)  путь к файлу со словарем
     * @param userWord - слово введенное пользователем
     * @return возвращает true, если userWord содержится в словаре по пути path
     * Ответственен за проверку наличия введенного пользователем слова в файле
     */
    @Override
    public boolean find(String path, String userWord) {
        try( BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
            return bufferedReader.lines().anyMatch(s -> s.equals(userWord));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * @param  path  (string)  путь к файлу со словарем
     * @return answer (string) рандомно выбранное из словаря слово
     * Отвественностью данного метода является: рандомно выбрать слово из файла и отдать его программе
     */
    @Override
    public String riddleWord(String path) {
        try {
            Random rnd = new Random();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            return bufferedReader.lines().toList().get(rnd.nextInt(ConstantsNumber.BOUND_OF_DICTIONARY.getNumber()));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
