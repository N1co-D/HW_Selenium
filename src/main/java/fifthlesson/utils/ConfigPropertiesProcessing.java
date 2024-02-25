package fifthlesson.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesProcessing {
    private final Properties properties = new Properties();

    public String getBrowserFromProperty() {
        File file = new File("src/main/resources/config.properties");
        String browser;
        try {
            properties.load(new FileInputStream(file));
            browser = properties.getProperty("browser");
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке файла!");
            throw new RuntimeException(e);
        }
        return browser;
    }
}
