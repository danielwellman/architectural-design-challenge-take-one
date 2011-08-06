package com.danielwellman.jschallenge.java1;

public interface IoFacade {
    String readFile(String filename);

    // Interesting: Should this actually be a separate interface?
    void createFile(String filename, String contents);
}
