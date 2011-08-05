package com.danielwellman.jschallenge.java1;


import java.io.PrintStream;

public class Rot13ConverterApplication {
    private final IoFacade ioFacade;
    private final Encoder encoder;
    private final PrintStream output;

    public Rot13ConverterApplication(IoFacade ioFacade, Encoder encoder) {
        this(ioFacade, encoder, System.out);
    }

    public Rot13ConverterApplication(IoFacade ioFacade, Encoder encoder, PrintStream output) {
        this.ioFacade = ioFacade;
        this.encoder = encoder;
        this.output = output;
    }

    public void convert(String inputFilename, String outputFilename) {
        String source = ioFacade.readFile(inputFilename);
        String encodedMessage = encoder.encode(source);

        // Feels very procedural, thinking a set of listeners would help here
        ioFacade.createFile(outputFilename, encodedMessage);
        output.println(encodedMessage);
    }

    public static void main(String... args) {
        final String inputFilename = args[0];
        final String outputFilename = args[1];
        new Rot13ConverterApplication(new FileSystemFacade(), new Rot13Encoder()).convert(inputFilename, outputFilename);
    }
}
