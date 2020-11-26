package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Helper {
    private final Properties properties;

    public Helper() {
        BufferedReader reader;
        String propertyFilePath = "src/test/resources/config/testData.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String baseURL(String key) {
        String url = properties.getProperty(key);
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the testData.properties file");
    }

    public String userEmail(String userEmail) {
        String uEmail = properties.getProperty(userEmail);
        if (uEmail != null) return uEmail;
        else throw new RuntimeException("EmailId not specified in the testData.properties file");
    }

    public String userPassword(String password) {
        String passwd = properties.getProperty(password);
        if (passwd != null) return passwd;
        else throw new RuntimeException("Password not specified in the testData.properties file");
    }
}