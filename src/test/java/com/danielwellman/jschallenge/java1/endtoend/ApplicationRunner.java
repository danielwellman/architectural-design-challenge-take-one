package com.danielwellman.jschallenge.java1.endtoend;

import com.danielwellman.jschallenge.java1.Main;
import com.danielwellman.jschallenge.java1.unit.ConfigurationTest;

public class ApplicationRunner {

    public void runUsing(String inputFilename, String outputFilename) {
        Main.main(inputFilename, outputFilename);
    }

    public void useTestMode() {
        System.setProperty(ConfigurationTest.TESTMODE_PROPERTY_NAME, "true");
    }

    public void resetRunMode() {
        System.clearProperty(ConfigurationTest.TESTMODE_PROPERTY_NAME);
    }
}
