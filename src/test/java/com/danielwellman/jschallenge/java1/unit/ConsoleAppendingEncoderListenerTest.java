package com.danielwellman.jschallenge.java1.unit;

import com.danielwellman.jschallenge.java1.EncoderListener;
import com.danielwellman.jschallenge.java1.OutputWriter;
import com.danielwellman.jschallenge.java1.app.ConsoleAppendingEncoderListener;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class ConsoleAppendingEncoderListenerTest {
    private final Mockery context = new Mockery();
    private final OutputWriter out = context.mock(OutputWriter.class);


    @Test
    public void writesMessageToTheOutputStream() {
        context.checking(new Expectations() {{
            oneOf(out).println("Hello, world!");
        }});

        final EncoderListener listener = new ConsoleAppendingEncoderListener(out);

        listener.messageEncoded("Hello, world!");
    }
}
