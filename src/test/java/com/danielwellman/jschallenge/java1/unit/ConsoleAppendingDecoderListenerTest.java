package com.danielwellman.jschallenge.java1.unit;

import com.danielwellman.jschallenge.java1.ConsoleAppendingDecoderListener;
import com.danielwellman.jschallenge.java1.DecoderListener;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class ConsoleAppendingDecoderListenerTest {

    /**
     * Interesting - I had to use containsString since
     * I used println.  But should I care that this actually prints with a
     * newline or not?
     */
    @Test
    public void writesMessageToTheOutputStream() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final DecoderListener listener = new ConsoleAppendingDecoderListener(new PrintStream(out));

        listener.messageDecoded("Hello, world!");

        assertThat(out.toString(), containsString("Hello, world!"));
    }
}
