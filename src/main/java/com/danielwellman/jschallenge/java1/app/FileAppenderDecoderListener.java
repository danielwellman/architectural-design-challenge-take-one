package com.danielwellman.jschallenge.java1.app;

import com.danielwellman.jschallenge.java1.DecoderListener;
import com.danielwellman.jschallenge.java1.OutputWriter;

public class FileAppenderDecoderListener implements DecoderListener {
    private final OutputWriter file;

    public FileAppenderDecoderListener(OutputWriter file) {
        this.file = file;
    }

    public void messageDecoded(String message) {
        file.println(message);
    }
}
