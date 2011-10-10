package com.danielwellman.jschallenge.java1.endtoend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class EndToEndTest {
    private static final String IRRELEVANT_FILENAME = "irrelevant";

    private final FileSystemTester fileSystem = new FileSystemTester("test_folder");
    private final ApplicationRunner application = new ApplicationRunner();
    private final ConsoleCapturer console = new ConsoleCapturer();

    @Before
    public void setUp() throws IOException {
        fileSystem.clearOutputFolder();
        console.beginCapturingSystemOut();
        application.useTestMode();
    }

    @After
    public void tearDown() {
        console.restoreSystemOut();
        application.resetRunMode();
    }

    @Test
    public void convertsToRot13AndStoresToANewFile() throws Exception {
        fileSystem.containsAFile("in.txt", "The dog barks at midnight.");

        application.runUsing("in.txt", "out.txt");

        fileSystem.hasCreatedAFile("out.txt", "Gur qbt onexf ng zvqavtug.");
    }

    @Test
    public void printsConvertedStringToTheConsole() throws Exception {
        fileSystem.containsAFile("in.txt", "The dog barks at midnight.");

        application.runUsing("in.txt", IRRELEVANT_FILENAME);

        console.hasDisplayed("Gur qbt onexf ng zvqavtug.");
    }

    // TODO Test: Incorrect command line arguments, parses error?
}
