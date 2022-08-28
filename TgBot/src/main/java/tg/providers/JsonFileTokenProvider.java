package tg.providers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class JsonFileTokenProvider implements TokenProvider {

    private final Path pathToFile;
    Logger logger = Logger.getLogger(JsonFileTokenProvider.class.getName());

    public JsonFileTokenProvider(Path pathToFile) {
        this.pathToFile = pathToFile;
    }

    public JsonFileTokenProvider(String pathToFile) {
        this.pathToFile = Paths.get(pathToFile);
    }


    @Override
    public String get() {
        try {
            return Files.readString(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("Some exception in " + pathToFile);
        }

        return null;
    }
}
