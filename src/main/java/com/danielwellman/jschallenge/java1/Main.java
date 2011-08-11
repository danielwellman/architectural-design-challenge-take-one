package com.danielwellman.jschallenge.java1;


import com.danielwellman.jschallenge.java1.javaio.JavaFileSystemFacade;
import com.danielwellman.jschallenge.java1.javaio.JavaSystemConsoleOut;

public class Main {
    private final IoFacade ioFacade;
    private final Encoder encoder;
    private final ConsoleOut output;

    public Main(IoFacade ioFacade, Encoder encoder, ConsoleOut out) {
        this.ioFacade = ioFacade;
        this.encoder = encoder;
        this.output = out;
    }

    public void convert(String inputFilename, String outputFilename) {
        final ConverterApplication converter = new ConverterApplication(ioFacade, encoder);
        converter.addListener(new ConsoleAppendingDecoderListener(output));
        // Weird - mixing the construction of the object with a one-off temporal filename.
        // ... seems like something is amiss here.
        converter.addListener(new FileAppenderDecoderListener(ioFacade, outputFilename));

        converter.convert(inputFilename);
    }

    public static void main(String... args) {
        final String inputFilename = args[0];
        final String outputFilename = args[1];
        new Main(new JavaFileSystemFacade(), new Rot13Encoder(), new JavaSystemConsoleOut()).convert(inputFilename, outputFilename);
    }
}
