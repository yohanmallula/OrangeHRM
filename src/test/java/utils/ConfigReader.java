package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/java/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties from custom path");
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
