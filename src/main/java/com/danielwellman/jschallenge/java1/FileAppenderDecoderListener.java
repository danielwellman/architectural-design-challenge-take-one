package com.danielwellman.jschallenge.java1;

public class FileAppenderDecoderListener implements DecoderListener {
    private final IoWriter ioWriter;
    private final String filename;

    public FileAppenderDecoderListener(IoWriter ioWriter, String filename) {
        this.ioWriter = ioWriter;
        this.filename = filename;
    }

    public void messageDecoded(String message) {
        ioWriter.createFile(filename, message);
    }
}
