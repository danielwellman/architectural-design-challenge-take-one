package com.danielwellman.jschallenge.java1.endtoend;

import com.danielwellman.jschallenge.java1.Rot13Converter;

public class ApplicationRunner {
    private FileSystemTester fileSystem;

    public ApplicationRunner(FileSystemTester fileSystem) {
        this.fileSystem = fileSystem;
    }

    public void runUsing(String inputFilename, String outputFilename) {
        new Rot13Converter().convert(inputFilename, outputFilename);
    }
}
