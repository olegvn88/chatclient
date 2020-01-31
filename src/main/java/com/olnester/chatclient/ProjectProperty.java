package com.olnester.chatclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectProperty {
    static String getProperty(String name) {
        Properties properties = new Properties();
        try (InputStream input = ProjectProperty.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                return "Sorry, unable to find config.properties";
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties.getProperty(name);
    }
}