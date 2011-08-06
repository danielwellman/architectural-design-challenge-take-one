package com.danielwellman.jschallenge.java1;

import java.io.PrintStream;

public class ConsoleAppendingDecoderListener implements DecoderListener {
    private final PrintStream printStream;

    public ConsoleAppendingDecoderListener(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void messageDecoded(String message) {
        printStream.println(message);
    }
}
