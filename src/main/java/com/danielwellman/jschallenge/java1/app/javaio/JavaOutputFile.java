package com.danielwellman.jschallenge.java1.app.javaio;

import com.danielwellman.jschallenge.java1.IoFacadeException;
import com.danielwellman.jschallenge.java1.OutputWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class JavaOutputFile implements OutputWriter {

    private final FileWriter fileWriter;

    public JavaOutputFile(String filename) {
        final File file = new File(filename);
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            throw new IoFacadeException("Couldn't create file: " + e.getMessage());
        }
    }

    public void println(String message) {
        try {
            fileWriter.write(message);
            fileWriter.flush();
        } catch (IOException e) {
            throw new IoFacadeException("Couldn't write to file: " + e.getMessage());
        }
    }
}
