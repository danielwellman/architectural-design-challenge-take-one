package com.danielwellman.jschallenge.java1.unit;

import com.danielwellman.jschallenge.java1.FileAppenderDecoderListener;
import com.danielwellman.jschallenge.java1.OutputWriter;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JMock.class)
public class FileAppenderDecoderListenerTest {
    private final Mockery context = new Mockery();
    private final OutputWriter file = context.mock(OutputWriter.class);

    @Test
    public void testSavesTheMessageToAFile() {
        final String message = "message text.";

        context.checking(new Expectations() {{
            oneOf(file).println(message);
        }});

        final FileAppenderDecoderListener listener = new FileAppenderDecoderListener(file);
        listener.messageDecoded(message);
    }
}
