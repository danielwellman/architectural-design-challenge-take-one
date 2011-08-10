package com.danielwellman.jschallenge.java1;

// This interface is weird; it's only required because
// the Converter needs to provide dependencies that can
// both read and write to the file system.
public interface IoFacade extends IoWriter, IoReader {
}
