/**
 * Класс Main
 */
public class MainAppWordle  {

    public static void main(String[] args) {
        String answer = "посох";  // здесь задаётся загаднное слово
        GameData model = new GameData();
        GameController controller = new GameController();
        GameRendering view = new GameRendering();

        int countOfTry = 0;
        while(countOfTry < 6){
            controller.goTry(model, answer);
            view.getView(model);
            countOfTry++;
        }
        System.out.println("Unfortunately, you have run out of  trys. Try again another time!");
    }


}

