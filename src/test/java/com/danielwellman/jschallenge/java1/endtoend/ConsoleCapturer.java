package com.danielwellman.jschallenge.java1.endtoend;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class ConsoleCapturer {

    private final ByteArrayOutputStream newOut = new ByteArrayOutputStream();
    private PrintStream originalSystemOut;

    public void beginCapturingSystemOut() {
        originalSystemOut = System.out;
        System.setOut(capturingSystemOut());
    }

    private PrintStream capturingSystemOut() {
        return new PrintStream(newOut);
    }

    public void restoreSystemOut() {
        System.setOut(originalSystemOut);
    }

    public void hasDisplayed(String message) {
        assertThat("Console did not display expected message", newOut.toString(), containsString(message));
    }
}
