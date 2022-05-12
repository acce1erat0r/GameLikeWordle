import java.util.Scanner;

public class GameController {

    private final Scanner scanner = new Scanner(System.in);
    GameLogic engine = new GameLogic();

    public void goTry(GameData gameData) {
        System.out.println("Write your guess");
        String guessWord = scanner.next();
        engine.gameLogic( guessWord, gameData, "полог"); //hardcode whatever :)
    }
}
