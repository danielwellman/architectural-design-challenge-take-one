package com.danielwellman.jschallenge.java1;

public class JavaSystemConsoleOut implements ConsoleOut {

    public void println(String message) {
        System.out.println(message);
    }
}
