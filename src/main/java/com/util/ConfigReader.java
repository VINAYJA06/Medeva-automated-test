package com.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    private String pathToConfig = "E:\\Medeva Config File\\config.properties";

    public ConfigReader() throws IOException {
        BufferedReader reader;
        properties = new Properties();
        reader = new BufferedReader(new FileReader(pathToConfig));
        properties.load(reader);
    }
    public String getBrowser() {
        String Browser = properties.getProperty("browser");
        if (Browser != null) {
            return Browser;
        } else {
            throw new RuntimeException("browser not specified in the config.properties file");
        }
    }
    public String getTestingUrl() {
        String testingUrl = properties.getProperty("testing_url");
        if (testingUrl != null) {
            return testingUrl;
        } else {
            throw new RuntimeException("Testing Server Url not specified in the config.properties file");
        }
    }
    public String getTestingUsername() {
        String testingUsername = properties.getProperty("testing_username");
        if (testingUsername != null) {
            return testingUsername;
        } else {
            throw new RuntimeException("Testing Server Username not specified in the config.properties file");
        }
    }
    public String getInvalidPPStagingUsername() {
        String invalidPPStagingUsername = properties.getProperty("invalid_pp_staging_username");
        if (invalidPPStagingUsername != null) {
            return invalidPPStagingUsername;
        } else {
            throw new RuntimeException("Invalid Testing Server Username not specified in the config.properties file");
        }
    }
    public String getTestingPassword() {
        String testingPassword = properties.getProperty("testing_password");
        if (testingPassword != null) {
            return testingPassword;
        } else {
            throw new RuntimeException("Testing Server Password not specified in the config.properties file");
        }
    }
    public String getInvalidPPStagingPassword() {
        String invalidPPStagingPassword = properties.getProperty("invalid_pp_staging_password");
        if (invalidPPStagingPassword != null) {
            return invalidPPStagingPassword;
        } else {
            throw new RuntimeException("Invalid Testing Server Password not specified in the config.properties file");
        }
    }



}
