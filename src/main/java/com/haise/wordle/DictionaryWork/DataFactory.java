package com.haise.wordle.DictionaryWork;

public class DataFactory implements IDataFactory{
    @Override
    public DataLetters createData() {
        return new DataLetters();
    }
}
