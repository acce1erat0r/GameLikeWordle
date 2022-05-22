import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DictionaryReader implements IDictReader {
    @Override
    public List<String> read(String path) {
        try {
            return  Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e); //TODO: добавить класс эксепшенов
        }
    }
}
