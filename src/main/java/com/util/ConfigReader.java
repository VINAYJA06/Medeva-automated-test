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
    public String getValidTestingUsername() {
        String validTestingUsername = properties.getProperty("valid_testing_username");
        if (validTestingUsername != null) {
            return validTestingUsername;
        } else {
            throw new RuntimeException("Testing Server Username not specified in the config.properties file");
        }
    }
    public String getInvalidTestingUsername() {
        String invalidTestingUsername = properties.getProperty("invalid_testing_username");
        if (invalidTestingUsername != null) {
            return invalidTestingUsername;
        } else {
            throw new RuntimeException("Invalid Testing Server Username not specified in the config.properties file");
        }
    }
    public String getValidTestingPassword() {
        String validTestingPassword = properties.getProperty("valid_testing_password");
        if (validTestingPassword != null) {
            return validTestingPassword;
        } else {
            throw new RuntimeException("Testing Server Password not specified in the config.properties file");
        }
    }
    public String getInvalidTestingPassword() {
        String invalidTestingPassword = properties.getProperty("invalid_testing_password");
        if (invalidTestingPassword != null) {
            return invalidTestingPassword;
        } else {
            throw new RuntimeException("Invalid Testing Server Password not specified in the config.properties file");
        }
    }

    public String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("report_config_path");
        if(reportConfigPath!= null) {
            return reportConfigPath;
        }else {
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
        }
    }



}
