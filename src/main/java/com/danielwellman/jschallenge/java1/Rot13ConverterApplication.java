package com.danielwellman.jschallenge.java1;


import java.io.PrintStream;

public class Rot13ConverterApplication {
    private final IoFacade ioFacade;
    private final Encoder encoder;
    private final PrintStream output = System.out;

    public Rot13ConverterApplication(IoFacade ioFacade, Encoder encoder) {
        this.ioFacade = ioFacade;
        this.encoder = encoder;
    }

    public void convert(String inputFilename, String outputFilename) {
        final Rot13Converter converter = new Rot13Converter(ioFacade, encoder);
        converter.addListener(new ConsoleAppendingDecoderListener(output));
        // Weird - mixing the construction of the object with a one-off temporal filename.
        // ... seems like something is amiss here.
        converter.addListener(new FileAppenderDecoderListener(ioFacade, outputFilename));

        converter.convert(inputFilename);
    }

    public static void main(String... args) {
        final String inputFilename = args[0];
        final String outputFilename = args[1];
        new Rot13ConverterApplication(new FileSystemFacade(), new Rot13Encoder()).convert(inputFilename, outputFilename);
    }
}
