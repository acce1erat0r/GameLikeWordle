import java.io.Console;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class MainGame {


    public static void main(String[] args) {

        Set<String> words = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        //TODO: повторяющиеся символы и методы типа indexOf, которые возвращают первое вхождение
        Collections.addAll(words, "black", "block", "chest", "dance", "death", "krabb");

        List<String> answer = Arrays.asList("b", "l", "a", "c", "k");



        List<String> answerConstruct = new ArrayList<>();
        Collections.addAll(answerConstruct, "?","?","?","?","?" );



        List<List<String>> tryingsList = new ArrayList<>();
        List<String> unknownLetter = new ArrayList<>();



        int trys = 0;
        while(trys < 6){
            System.out.println( "Write your guess");
            String guessWord = scanner.next();
            List<String> guessList = List.of(guessWord.split(""));

            if (words.contains(guessWord.toLowerCase())) { // если слово есть в словаре
                if (!answer.equals(guessList)) { // Если слово не равно правильному //TODO: после break все равно выводится tryingsList

                    for (int j = 0; j < 5; j++) {
                        if (answer.contains(guessList.get(j).toString().toLowerCase())) { // Если символ из введенного слова есть в ответе
                            if (guessList.get(j).equals(answer.get(j))) // если индекс символа из введенного слова совпадет с индексом символа в ответе
                            {
                                answerConstruct.set(j, guessList.get(j).toUpperCase());

                            } else {  // если индексы символов не совпадают
                                answerConstruct.set(j, guessList.get(j).toLowerCase());
                            }

                        } else { // если символа нет в слове

                            if (!unknownLetter.contains(guessList.get(j))){
                                unknownLetter.add(guessList.get(j));
                            }

                        }
                        System.out.println();

                    }
                    tryingsList.add(new ArrayList<>(answerConstruct));
                    answerConstruct.clear();
                    Collections.addAll(answerConstruct, "?","?","?","?","?" );

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
