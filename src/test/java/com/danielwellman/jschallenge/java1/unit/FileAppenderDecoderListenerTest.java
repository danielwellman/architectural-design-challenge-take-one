package com.danielwellman.jschallenge.java1.unit;

import com.danielwellman.jschallenge.java1.FileAppenderDecoderListener;
import com.danielwellman.jschallenge.java1.IoWriter;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JMock.class)
public class FileAppenderDecoderListenerTest {
    private final Mockery context = new Mockery();
    private final IoWriter ioWriter = context.mock(IoWriter.class);

    @Test
    public void testSavesTheMessageToAFile() {
        final String outputFilename = "filename";
        final String message = "message text.";

        context.checking(new Expectations() {{
            oneOf(ioWriter).createFile(outputFilename, message);
        }});

        // Interesting: Weird because it takes the filename and the io Facade...
        // ... these arguments don't feel like they should be temporally coupled
        final FileAppenderDecoderListener listener = new FileAppenderDecoderListener(ioWriter, outputFilename);
        listener.messageDecoded(message);
    }
}
