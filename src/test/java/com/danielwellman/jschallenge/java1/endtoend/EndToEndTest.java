package com.danielwellman.jschallenge.java1.endtoend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class EndToEndTest {
    private static final String IRRELEVANT_FILENAME = "irrelevant";

    private final FileSystemTester fileSystem = new FileSystemTester();
    private final ApplicationRunner application = new ApplicationRunner();
    private final ConsoleCapturer console = new ConsoleCapturer();

    @Before
    public void setUp() throws IOException {
        fileSystem.clearOutputFolder();
        console.beginCapturingSystemOut();
    }

    @After
    public void tearDown() {
        console.restoreSystemOut();
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

        console.hasDisplayed("Gur qbt onexf ng zvqavtug.");  // This method is a little weird - only works if you call specific run w/ console
    }

    // TODO Test: Incorrect command line arguments, parses error?
}
