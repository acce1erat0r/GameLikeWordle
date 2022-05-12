import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MainGame {


    public static void main(String[] args) throws IOException {


        //TODO: повторяющиеся символы и методы типа indexOf, которые возвращают первое вхождение
        List<String> words = Files.readAllLines(Paths.get("src/main/resources/dictionary.txt"));
        Scanner scanner = new Scanner(System.in);
        String answerWord = "staff";  // Слово которое мы загадываем

        // Подсчет количества вхождений каждого символа в загаданном слове
        List<String> answer = List.of(answerWord.split(""));
        Map<String, Integer> frequencyAnswer = answer.stream()
                .collect(Collectors.toMap(
                        e -> e,
                        e -> 1,
                        Integer::sum
                ));






        List<String> answerConstruct = new ArrayList<>();
        Collections.addAll(answerConstruct, "?", "?", "?", "?", "?");
        Map<String, Integer> frequencyAnswerConstruct = answer.stream()
                .collect(Collectors.toMap(
                        e -> e,
                        e -> 1,
                        Integer::sum
                ));

        List<List<String>> tryingsList = new ArrayList<>();
        List<String> unknownLetter = new ArrayList<>();


        int trys = 0;
        while (trys < 6) {
            System.out.println("Write your guess");
            String guessWord = scanner.next();
            List<String> guessList = List.of(guessWord.split(""));



            if (words.contains(guessWord.toLowerCase())) { // если слово есть в словаре
                if (!answer.equals(guessList)) { // Если слово не равно правильному

                    for (int j = 0; j < 5; j++) {
                        if (answer.contains(guessList.get(j).toLowerCase())) { // Если символ из введенного слова есть в ответе
                            if (guessList.get(j).equals(answer.get(j))) // если индекс символа из введенного слова совпадет с индексом символа в ответе
                            {
                                answerConstruct.set(j, guessList.get(j).toUpperCase());

                            } else {  // если индексы символов не совпадают
                                if (!answerConstruct.contains(guessList.get(j))){ // Если контейнер ответа не содержит символа то добавляем
                                    answerConstruct.set(j, guessList.get(j).toLowerCase());
                                } else { // А если содержит, то проверяем
                                    if (frequencyAnswer.get(guessList.get(j)) <= frequencyAnswerConstruct.get(guessList.get(j))){
                                        answerConstruct.set(j, guessList.get(j).toLowerCase());
                                    }
                                }

                            }

                        } else { // если символа нет в слове

                            if (!unknownLetter.contains(guessList.get(j))) {
                                unknownLetter.add(guessList.get(j));
                            }

                        }


                    }
                    tryingsList.add(new ArrayList<>(answerConstruct));
                    answerConstruct.clear();
                    Collections.addAll(answerConstruct, "?", "?", "?", "?", "?");

                } else {

                    System.out.println("Word " + guessWord + " that right answer congratulation!!!");
                    break;
                }

            } else { // если слова нет в словаре
                System.out.println("Such word hasn't in dictionary ");
                continue;
            }


            System.out.println("Your previous tryings");
            // Блок вывода предыдущих попыток
            tryingsList.forEach(System.out::println);
            System.out.println("unknown letters");
            System.out.println(unknownLetter);
            System.out.println("___________________________________");
            trys++;

        }


    }

}
