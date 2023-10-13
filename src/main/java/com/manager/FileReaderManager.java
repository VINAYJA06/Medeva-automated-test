package com.manager;

import com.util.ConfigReader;
import java.io.IOException;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();

    private static ConfigReader configReader;

    private FileReaderManager(){

    }

    public static FileReaderManager getInstance(){
        return fileReaderManager;
    }

    public ConfigReader getConfigReader() throws IOException {
        return (configReader == null) ? new ConfigReader() : configReader;
    }

}
