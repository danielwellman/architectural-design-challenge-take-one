package com.danielwellman.jschallenge.java1;

public class FileAppenderDecoderListener implements DecoderListener {
    private final IoFacade ioFacade;
    private final String filename;

    public FileAppenderDecoderListener(IoFacade ioFacade, String filename) {
        this.ioFacade = ioFacade;
        this.filename = filename;
    }

    public void messageDecoded(String message) {
        ioFacade.createFile(filename, message);

    }
}
