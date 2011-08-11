package com.danielwellman.jschallenge.java1;

public interface FileSystemFacade {
    OutputWriter createFile(String filename);

    InputReader openFileForRead(String filename);
}
