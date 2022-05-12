/**
 * Класс занимающийся отрисовкой UI игры
 */
public class GameRendering {


    public void getView(GameData gameData) {
        System.out.println("________________________________________________________");
        System.out.println("Big letters -> letter in the word and in right place. " + " |");
        System.out.println("Small letters -> letter in the word, but wrong place" + "   |");
        System.out.println("_______________________________________________________|");
        System.out.println("Your previous tryings"  );
        gameData.getTryingsList().forEach(System.out::println);
        System.out.println("unknown letters");
        System.out.println(gameData.getNotExistLetters());
        System.out.println("####################################################");


    }


}
