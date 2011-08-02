package com.danielwellman.jschallenge.java1;


public class Rot13Converter {
    private IoFacade ioFacade;
    private Encoder encoder;

    public Rot13Converter(IoFacade ioFacade, Encoder encoder) {
        this.ioFacade = ioFacade;
        this.encoder = encoder;
    }

    public void convert(String inputFilename, String outputFilename) {
        String source = ioFacade.readFile(inputFilename);
        String encodedMessage = encoder.encode(source);
        ioFacade.createFile(outputFilename, encodedMessage);
    }
}
