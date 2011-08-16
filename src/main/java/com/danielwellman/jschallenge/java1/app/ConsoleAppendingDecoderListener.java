package com.danielwellman.jschallenge.java1.app;

import com.danielwellman.jschallenge.java1.DecoderListener;
import com.danielwellman.jschallenge.java1.OutputWriter;

public class ConsoleAppendingDecoderListener implements DecoderListener {
    private final OutputWriter out;

    public ConsoleAppendingDecoderListener(OutputWriter out) {
        this.out = out;
    }

    public void messageDecoded(String message) {
        out.println(message);
    }
}
