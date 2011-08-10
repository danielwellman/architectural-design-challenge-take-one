package com.danielwellman.jschallenge.java1;

public class ConsoleAppendingDecoderListener implements DecoderListener {
    private final ConsoleOut out;

    public ConsoleAppendingDecoderListener(ConsoleOut out) {
        this.out = out;
    }

    public void messageDecoded(String message) {
        out.println(message);
    }
}
