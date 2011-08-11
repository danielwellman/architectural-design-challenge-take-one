package com.danielwellman.jschallenge.java1.javaio;

import com.danielwellman.jschallenge.java1.ConsoleOut;

public class JavaSystemConsoleOut implements ConsoleOut {

    public void println(String message) {
        System.out.println(message);
    }
}
