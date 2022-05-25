package com.haise.wordle;

import com.haise.wordle.DictionaryWork.DictionaryWorker;
import com.haise.wordle.constants.ConstantsString;
import com.haise.wordle.constants.ViewMessage;
import com.haise.wordle.interfaces.GameLogicFacade;
import com.haise.wordle.interfaces.Playable;
import com.haise.wordle.interfaces.Puzzler;

import java.util.ArrayList;
import java.util.List;

/**
 * Главный "фасад" класс wordle. Здесь инициализируются компоненты приложения ответственные за логику GameLogicFacade,
 *                                              DictionaryWorker.
 * И компонент пользовательского интерфейса - класс GameEventListener
 */
public class Game implements Playable {
    private  final GameLogicFacade gameLogicFacade = new com.haise.wordle.GameLogicFacade();
    private final GameEventListener listener  = new GameEventListener();
    private String userGuess;
    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }
    private final Puzzler puzzler = new DictionaryWorker();

    private final String answer =  puzzler.riddleWord(ConstantsString.PATH_EN.getTitle());



    private static int counter = 0;
    private final List<StringBuilder> trys = new ArrayList<>();

    /**
     * Главный метод wordle, отвечающий за запуск игрового цикла.
     */
    @Override
    public void goGame() {
        listener.addListener(new UserIOWorker());
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
