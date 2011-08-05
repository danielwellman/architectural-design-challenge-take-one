package com.danielwellman.jschallenge.java1.endtoend;

import com.danielwellman.jschallenge.java1.FileSystemFacade;
import com.danielwellman.jschallenge.java1.Rot13ConverterApplication;
import com.danielwellman.jschallenge.java1.Rot13Encoder;

public class ApplicationRunner {

    public void runUsing(String inputFilename, String outputFilename) {
        Rot13ConverterApplication.main(inputFilename, outputFilename);
    }

    // TODO Weird... The method above is end-to-end via the main() method, but this one is not.  Repeats constructor parameters.
    public void runUsing(String inputFilename, String outputFilename, ConsoleCapturer console) {
        final Rot13ConverterApplication application = new Rot13ConverterApplication(new FileSystemFacade(), new Rot13Encoder(), console.logger());
        application.convert(inputFilename, outputFilename);
    }
}
