package com.testautomation.conf;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class ConfigLoader {
    public static Configuration loadConfig(){
        ObjectMapper objectMapper = new ObjectMapper();
        String configFile = "config.json";
        try{
            InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream(configFile);
            return objectMapper.readValue(inputStream, Configuration.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
