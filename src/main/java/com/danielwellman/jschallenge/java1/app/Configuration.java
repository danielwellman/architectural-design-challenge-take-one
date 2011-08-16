package com.danielwellman.jschallenge.java1.app;

public class Configuration {

    private static final String TESTMODE_PROPERTY_NAME = "challenge.testmode";

    public String path() {
        if (systemTestModePropertyPresent()) {
            return "test_folder";
        } else return "production";
    }

    private boolean systemTestModePropertyPresent() {
        return System.getProperty(TESTMODE_PROPERTY_NAME) != null;
    }
}
