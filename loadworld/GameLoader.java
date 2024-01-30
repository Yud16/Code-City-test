package loadworld;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class GameLoader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static SpiderConfiguration loadSpiderConfiguration() {
        try {
            return objectMapper.readValue(new File("src/spiderConfiguration.json"), SpiderConfiguration.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading spiderConfiguration.json.");
            return null;
        }
    }
}
