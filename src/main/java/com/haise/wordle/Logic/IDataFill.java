package com.haise.wordle.Logic;

import com.haise.wordle.DictionaryWork.DataLetters;

public interface IDataFill {
   void fillData(DataLetters data, String userGuess, String answer);
}
