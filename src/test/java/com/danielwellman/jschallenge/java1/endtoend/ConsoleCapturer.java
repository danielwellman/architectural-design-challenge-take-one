package com.danielwellman.jschallenge.java1.endtoend;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class ConsoleCapturer {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    public PrintStream logger() {
        return new PrintStream(out);
    }

    public void hasDisplayed(String message) {
        assertThat("Console did not display expected message", out.toString(), containsString(message));
    }
}
