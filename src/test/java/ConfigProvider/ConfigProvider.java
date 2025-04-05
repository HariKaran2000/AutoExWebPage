package ConfigProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
    private static Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/properties/nextGen.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseURL() {
        return getProperty("baseURL");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }
}
