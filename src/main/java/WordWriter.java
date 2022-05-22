import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WordWriter implements IWriter {
    String userWord;
    Scanner sc = new Scanner(System.in);
    @Override
    public String write() {


        userWord = sc.nextLine();
        return userWord;
    }
}
