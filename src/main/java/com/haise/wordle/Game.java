package com.haise.wordle;

import com.haise.wordle.DictionaryWork.DictionaryWorker;
import com.haise.wordle.constants.ConstantsString;
import com.haise.wordle.constants.ViewMessage;
import com.haise.wordle.interfaces.IGame;
import com.haise.wordle.interfaces.IGameLogicFacade;
import com.haise.wordle.interfaces.IPuzzler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game implements IGame {
    private  final IGameLogicFacade gameLogicFacade = new GameLogicFacade();
    private final GameEventListener listener  = new GameEventListener();
    private String userGuess;
    private final IPuzzler puzzler = new DictionaryWorker();

    private final String answer =  puzzler.riddleWord(ConstantsString.PATH_EN.getTitle());

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

    private static int counter = 0;
    private final List<StringBuilder> trys = new ArrayList<>();
    @Override
    public void goGame() {
        listener.addListener(new ViewHandler());
        listener.fireEvent(ViewMessage.GREETINGS);
        while (counter < 6){
            listener.fireEvent(ViewMessage.WRITE_WORD);
            listener.fireEvent(this);
            trys.add(gameLogicFacade.checkWord(userGuess, listener, answer));
            listener.fireEvent(trys);
            counter++;
        }
        listener.fireEvent(ViewMessage.LOSE_MESSAGE);
        listener.fireEvent(answer);
    }
}
