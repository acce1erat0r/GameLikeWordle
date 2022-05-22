import java.util.ArrayList;
import java.util.List;

public class Game implements IGame{

    private final IWriter writer = new WordWriter();
    IGameLogicFacade gameLogicFacade = new GameLogicFacade();
    private static int counter = 0;
    private final List<StringBuilder> trys = new ArrayList<>();
    @Override
    public void goGame() {
        System.out.println(ConstantsString.GREETINGS.getTitle());
        while (counter < 6){
            System.out.println(ConstantsString.WRITE_WORD.getTitle());
            String userGuess = writer.write();
            trys.add(gameLogicFacade.checkWord(userGuess));
            trys.forEach(System.out::println);
            counter++;

        }
        System.out.println(ConstantsString.LOSE_MESSAGE.getTitle());
        //TODO: добавить вывод загаданного слова, если игрок проиграл

    }
}
