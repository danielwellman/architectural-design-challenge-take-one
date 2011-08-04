package com.danielwellman.jschallenge.java1;


public class Rot13ConverterApplication {
    private final IoFacade ioFacade;
    private final Encoder encoder;

    public Rot13ConverterApplication(IoFacade ioFacade, Encoder encoder) {
        this.ioFacade = ioFacade;
        this.encoder = encoder;
    }

    public void convert(String inputFilename, String outputFilename) {
        String source = ioFacade.readFile(inputFilename);
        String encodedMessage = encoder.encode(source);
        ioFacade.createFile(outputFilename, encodedMessage);
    }

    public static void main(String... args) {
        final String inputFilename = args[0];
        final String outputFilename = args[1];
        new Rot13ConverterApplication(new FileSystemFacade(), new Rot13Encoder()).convert(inputFilename, outputFilename);
    }
}
