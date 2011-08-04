package com.danielwellman.jschallenge.java1.endtoend;

import org.junit.Test;

public class EndToEndTest {
    private FileSystemTester fileSystem = new FileSystemTester();
    private ApplicationRunner application = new ApplicationRunner(fileSystem);

    @Test
    public void convertsToRot13AndStoresToANewFile() throws Exception {
        fileSystem.containsAFile("in.txt", "The dog barks at midnight.");

        application.runUsing("in.txt", "out.txt");

        fileSystem.hasCreatedAFile("out.txt", "Gur qbt onexf ng zvqavtug.");
    }

    // TODO test prints converted string to the console
//    console.hasDisplayed("Gur qbt onexf ng zvqavtug.");

    // TODO Test: Incorrect command line arguments, parses error?
}
