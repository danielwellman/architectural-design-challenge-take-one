package com.danielwellman.jschallenge.java1.javaio;

import com.danielwellman.jschallenge.java1.OutputWriter;

public class JavaSystemConsoleOut implements OutputWriter {

    public void println(String message) {
        System.out.println(message);
    }
}
