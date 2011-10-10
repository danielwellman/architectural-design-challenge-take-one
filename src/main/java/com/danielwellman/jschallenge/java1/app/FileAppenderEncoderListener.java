package com.danielwellman.jschallenge.java1.app;

import com.danielwellman.jschallenge.java1.EncoderListener;
import com.danielwellman.jschallenge.java1.OutputWriter;

public class FileAppenderEncoderListener implements EncoderListener {
    private final OutputWriter file;

    public FileAppenderEncoderListener(OutputWriter file) {
        this.file = file;
    }

    public void messageEncoded(String message) {
        file.println(message);
    }
}
