import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Dictionary {
    private  List<String> words;

    public List<String> getWords() {
        return words;
    }



    public void initDictionary(String language){
        try {
            words = Files.readAllLines(Paths.get("src/main/resources/dictionary_"+language + ".txt"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

