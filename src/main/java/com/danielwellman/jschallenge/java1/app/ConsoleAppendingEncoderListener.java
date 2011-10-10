package com.danielwellman.jschallenge.java1.app;

import com.danielwellman.jschallenge.java1.EncoderListener;
import com.danielwellman.jschallenge.java1.OutputWriter;

public class ConsoleAppendingEncoderListener implements EncoderListener {
    private final OutputWriter out;

    public ConsoleAppendingEncoderListener(OutputWriter out) {
        this.out = out;
    }

    public void messageEncoded(String message) {
        out.println(message);
    }
}
