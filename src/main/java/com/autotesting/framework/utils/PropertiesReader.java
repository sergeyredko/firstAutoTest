package com.autotesting.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader propertiesReader;
    private static Properties properties;
    private static String PATH_TO_PROPERTIES_FILE = "src//main//resources//config.properties";

    public static synchronized PropertiesReader getPropertiesReader() throws Exception{
        return (propertiesReader != null) ? propertiesReader : new PropertiesReader();
    }

    PropertiesReader() throws FileNotFoundException, IOException {
        synchronized (PropertiesReader.class) {
            if (propertiesReader != null) {
                throw new IllegalStateException();
            }
            properties = new Properties();
            properties.load(new FileInputStream(new File(PATH_TO_PROPERTIES_FILE)));
        }
    }

    public static String getLogin(){
        return properties.getProperty("username");
    }

    public static String getPassword(){
        return properties.getProperty("password");
    }
}
