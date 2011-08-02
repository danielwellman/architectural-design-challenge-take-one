package com.danielwellman.jschallenge.java1.endtoend;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class FileSystemTester {

    private static final String TEST_FOLDER_PATH = "test_folder";

    public String getTestFolderPath() {
        return TEST_FOLDER_PATH;
    }

    public void containsAFile(String filename, String contents) throws IOException {
        FileUtils.writeStringToFile(file(filename), contents);
    }

    public void hasCreatedAFile(String filename, String contents) throws IOException {
        File expectedFile = file(filename);
        assertThat("A file named " + filename + " should exist.",
                expectedFile.exists(), is(true));
        assertThat("File contents do not match", FileUtils.readFileToString(expectedFile), equalTo(contents));
    }

    private File file(String filename) {
        return new File(getTestFolderPath(), filename);
    }
}
