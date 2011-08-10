package com.danielwellman.jschallenge.java1.unit;

import com.danielwellman.jschallenge.java1.ConsoleAppendingDecoderListener;
import com.danielwellman.jschallenge.java1.ConsoleOut;
import com.danielwellman.jschallenge.java1.DecoderListener;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class ConsoleAppendingDecoderListenerTest {
    private final Mockery context = new Mockery();
    private final ConsoleOut out = context.mock(ConsoleOut.class);


    @Test
    public void writesMessageToTheOutputStream() {
        context.checking(new Expectations() {{
            oneOf(out).println("Hello, world!");
        }});

        final DecoderListener listener = new ConsoleAppendingDecoderListener(out);

        listener.messageDecoded("Hello, world!");
    }
}
