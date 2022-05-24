package com.haise.wordle.interfaces;

import com.haise.wordle.DictionaryWork.DataLetters;

public interface IWordConstructor {
    StringBuilder constructWord(DataLetters data);
}
