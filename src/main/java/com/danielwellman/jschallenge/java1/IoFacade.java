package com.danielwellman.jschallenge.java1;

public interface IoFacade {
    String readFile(String filename);

    void createFile(String filename, String contents);
}
