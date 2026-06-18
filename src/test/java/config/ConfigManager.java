package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();

    static {

        try {

            InputStream input = ConfigManager.class
                    .getClassLoader()
                    .getResourceAsStream(
                            "config.properties");

            properties.load(input);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Erro ao carregar config.properties",
                    e);
        }
    }

    public static String getBaseUrl() {

        return properties.getProperty(
                "base.url");
    }

    public static int getTimeout() {

        return Integer.parseInt(
                properties.getProperty(
                        "timeout"));
    }

    public static String getBrowser() {

        return properties.getProperty(
                "browser");
    }
}