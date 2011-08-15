package com.danielwellman.jschallenge.java1.integration;

import com.danielwellman.jschallenge.java1.InputReader;
import com.danielwellman.jschallenge.java1.OutputWriter;
import com.danielwellman.jschallenge.java1.endtoend.FileSystemTester;
import com.danielwellman.jschallenge.java1.javaio.JavaFileSystemFacade;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JavaFileSystemTests {

    private static final String SYSTEM_TEST_FOLDER = "systemTestFolder";
    private final FileSystemTester testFileSystem = new FileSystemTester(SYSTEM_TEST_FOLDER);
    private final JavaFileSystemFacade facade = new JavaFileSystemFacade(SYSTEM_TEST_FOLDER);

    @Before
    public void emptyFolder() throws IOException {
        testFileSystem.clearOutputFolder();
    }

    @Test
    public void writesContentsToAFile() throws IOException {
        final String filename = "filename.txt";
        final String message = "Sample test message.";

        OutputWriter file = facade.createFile(filename);
        file.println(message);

        testFileSystem.containsAFile(filename, message);
    }

    @Test
    public void readsFromAFile() throws IOException {
        final String filename = "somefile.txt";
        final String message = "Here is an expected message.";

        testFileSystem.containsAFile(filename, message);

        InputReader file = facade.openFileForRead(filename);
        String contents = file.read();
        assertThat(contents, is(message));
    }
}
