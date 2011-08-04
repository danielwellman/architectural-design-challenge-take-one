package com.danielwellman.jschallenge.java1.endtoend;

import com.danielwellman.jschallenge.java1.FileSystemFacade;
import com.danielwellman.jschallenge.java1.Rot13ConverterApplication;
import com.danielwellman.jschallenge.java1.Rot13Encoder;

public class ApplicationRunner {
    private FileSystemTester fileSystem;

    public ApplicationRunner(FileSystemTester fileSystem) {
        this.fileSystem = fileSystem;
    }

    public void runUsing(String inputFilename, String outputFilename) {
        // TODO Place this behind a wrapper or default arguments? Always want Rot13Encoder in production/end-to-end tests
        new Rot13ConverterApplication(new FileSystemFacade(fileSystem.getTestFolderPath()),
                new Rot13Encoder()).convert(inputFilename, outputFilename);
    }
}
