import java.util.*;

public class GameData {
    private final List<List<String>> tryingsList = new ArrayList<>();
    private final Set<String> notExistLetters = new TreeSet<>();

    public List<List<String>> getTryingsList() {
        return tryingsList;
    }

    public Set<String> getNotExistLetters() {
        return notExistLetters;
    }

    public void addGameAttributes(List<String> tryings, List<String> unknownLetters ){
        tryingsList.add(tryings);
        notExistLetters.addAll(unknownLetters);
    }
}
