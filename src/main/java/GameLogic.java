import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс ответственный за логику игры.
 * Основной метод класса вызывающийся из Main-класса gameLogic
 */
public class GameLogic {


    private final List<String> words;

    /**
     * Список из строк в который в зависимости от логики метода gameLogic будут помещаться символы, которые не встречаются в загаданном слове
     */
    private final List<String> unknownLetter = new ArrayList<>();
    /**
     * Список из строк в который в зависимости от логики метода gameLogic будут помещаться либо UpperCase символы, либо LowerCase
     */
    List<String> tryingConstructor = new LinkedList<>();
    /**
     * Поле копия списка tryingConstructor, для того, чтобы помещать в данную коллекцию только LowerCase символы,
     * чтобы затем использовать данный лист  для сравнения  и проверки на вхождение
     */
    List<String> copyTryingConstructorForIfStatements = new LinkedList<>();


    {
        try {
            //words = Files.readAllLines(Paths.get("src/main/resources/dictionary_en.txt")); Uncomment the line to use the English dictionary
            words = Files.readAllLines(Paths.get("src/main/resources/dictionary_ru.txt"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Метод ответственный за основную логику игры.
     * В данном методе сначала происходит очистка "буфферов"
     * Затем буфферы инициализируются  последовательностями из "?" строк.
     * Затем для более удобной работы с введенным пользователем словом и загаданным словом
     * из этих слов создаются списки.
     * Идет проверка на вхождение введенного пользователем слова в захардкоженный словарь.
     * Идет проверка на угадывание верного слова,
     * а затем начинает выполнятся метод compareLetterInWords.
     * После выполнения данного метода, который изменяет поля unknownLetter и tryingConstructor
     * вызывается метод класса GameData,  который заполняет внутренние поля, чтобы затем при помощи класса GameData
     * можно было отобразить их в классе GameRendering.
     */

    public void gameLogic(String guessWord, GameData gameData, String rightAnswer) {
        clearBuffer();
        Collections.addAll(tryingConstructor, "?", "?", "?", "?", "?");
        Collections.addAll(copyTryingConstructorForIfStatements, "?", "?", "?", "?", "?");

        List<String> answer = List.of(rightAnswer.split(""));

        List<String> guessList = List.of(guessWord.split(""));

        if (!words.contains(guessWord.toLowerCase())) {
            System.err.println("Such word hasn't in dictionary ");
            return;
        }
        if (answer.equals(guessList)) {
            System.err.println("Word " + guessWord.toUpperCase() + " that right answer congratulation!!!");
            System.exit(0);
            return;
        }

        compareLetterInWords(answer, guessList);

        gameData.addGameAttributes(new ArrayList<>(tryingConstructor), unknownLetter);
    }

    /**
     * Метод, который посимвольно сравнивает введенное пользователем слова с загаданным в программе словом (в классе GameController)
     * Если символ из введенного пользователем слова есть в загаданном,
     * то данный символ добавляется по изначальному индексу в tryingConstructor (ArrayList<String>) с применением метода toLowerCase,
     * если же данный символ имеет такой же индекс как и такой же символ из загаданного слова,
     * то он добавляется в tryingConstructor с применением метода toUpperCase().
     */

    private void compareLetterInWords(List<String> answer, List<String> guessList) {
        for (int j = 0; j < 5; j++) {
            if (answer.contains(guessList.get(j).toLowerCase())) {
                if (guessList.get(j).equals(answer.get(j))) {
                    if (Collections.frequency(answer, (guessList.get(j))) >=
                            Collections.frequency(copyTryingConstructorForIfStatements, (guessList.get(j))) + 1) {

                        tryingConstructor.set(j, guessList.get(j).toUpperCase());
                        copyTryingConstructorForIfStatements.set(j, guessList.get(j).toLowerCase());

                    } else {
                        Collections.swap(tryingConstructor, tryingConstructor.indexOf(guessList.get(j)), j);
                        Collections.swap(copyTryingConstructorForIfStatements, copyTryingConstructorForIfStatements.indexOf(guessList.get(j)), j);

                        tryingConstructor.set(j, tryingConstructor.get(j).toUpperCase());
                        copyTryingConstructorForIfStatements.set(j, copyTryingConstructorForIfStatements.get(j).toUpperCase());
                    }

                } else {
                    if (!copyTryingConstructorForIfStatements.contains(guessList.get(j))) {

                        tryingConstructor.set(j, guessList.get(j).toLowerCase());
                        copyTryingConstructorForIfStatements.set(j, guessList.get(j).toLowerCase());

                    } else {
                        if (Collections.frequency(answer, (guessList.get(j))) >=
                                Collections.frequency(copyTryingConstructorForIfStatements, (guessList.get(j))) + 1) {
                            tryingConstructor.set(j, guessList.get(j).toLowerCase());
                            copyTryingConstructorForIfStatements.set(j, guessList.get(j).toLowerCase());

                        }
                    }
                }
            } else {
                unknownLetter.add(guessList.get(j));
            }

        }
    }

    /**
     * Метод для очистки буфферов
     */
    private void clearBuffer() {
        tryingConstructor.clear();
        copyTryingConstructorForIfStatements.clear();
        unknownLetter.clear();
    }


}
