package com.haise.wordle.Logic;

import com.haise.wordle.DictionaryWork.DataLetters;

public interface IWordConstructor {
    StringBuilder constructWord(DataLetters data);
}
