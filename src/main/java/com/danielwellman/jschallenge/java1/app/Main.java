package com.danielwellman.jschallenge.java1.app;


import com.danielwellman.jschallenge.java1.ConverterApplication;
import com.danielwellman.jschallenge.java1.Encoder;
import com.danielwellman.jschallenge.java1.FileSystemFacade;
import com.danielwellman.jschallenge.java1.OutputWriter;
import com.danielwellman.jschallenge.java1.app.javaio.JavaFileSystemFacade;
import com.danielwellman.jschallenge.java1.app.javaio.JavaSystemConsoleOut;

public class Main {
    private final FileSystemFacade fileSystemFacade;
    private final Encoder encoder;
    private final OutputWriter output;

    public Main(FileSystemFacade fileSystemFacade, Encoder encoder, OutputWriter out) {
        this.fileSystemFacade = fileSystemFacade;
        this.encoder = encoder;
        this.output = out;
    }

    public void run(String inputFilename, String outputFilename) {
        final ConverterApplication converter = new ConverterApplication(encoder);
        converter.addListener(new ConsoleAppendingEncoderListener(output));
        converter.addListener(new FileAppenderEncoderListener(fileSystemFacade.createFile(outputFilename)));

        converter.convert(fileSystemFacade.openFileForRead(inputFilename));
    }

    public static void main(String... args) {
        final String inputFilename = args[0];
        final String outputFilename = args[1];
        final String fileSystemPath = new Configuration().path();
        new Main(new JavaFileSystemFacade(fileSystemPath), new Rot13Encoder(), new JavaSystemConsoleOut()).run(inputFilename, outputFilename);
    }
}
