package com.haise.wordle.DictionaryWork;

import com.haise.wordle.constants.ConstantsNumber;
import com.haise.wordle.interfaces.IFinderInDict;
import com.haise.wordle.interfaces.IPuzzler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class DictionaryWorker implements IFinderInDict, IPuzzler {
    @Override
    public boolean find(String path, String userWord) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            return bufferedReader.lines().anyMatch(s -> s.equals(userWord));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

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
