package config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    public ConfigReader() {
    }

    public static Properties initializeProperties() {
        Properties properties = new Properties();
        File proFile = new File(System.getProperty("user.dir") + "/src/test/java/config/config.properties");

        try {

            FileInputStream file = new FileInputStream(proFile);
            properties.load(file);

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return properties;
    }
}
