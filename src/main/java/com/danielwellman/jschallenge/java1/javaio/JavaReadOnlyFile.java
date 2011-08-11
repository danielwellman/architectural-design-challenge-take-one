package com.danielwellman.jschallenge.java1.javaio;

import com.danielwellman.jschallenge.java1.InputReader;
import com.danielwellman.jschallenge.java1.IoFacadeException;

import java.io.*;

public class JavaReadOnlyFile implements InputReader {

    private final BufferedReader fileReader;

    public JavaReadOnlyFile(String filename) {
        final File file = new File(filename);
        try {
            fileReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new IoFacadeException("Couldn't open file: " + e.getMessage());
        }
    }

    public String read() {
        try {
            return fileReader.readLine();
        } catch (IOException e) {
            throw new IoFacadeException("Couldn't read file: " + e.getMessage());
        }
    }
}
