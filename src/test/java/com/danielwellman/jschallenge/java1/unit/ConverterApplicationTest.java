package com.danielwellman.jschallenge.java1.unit;

import com.danielwellman.jschallenge.java1.ConverterApplication;
import com.danielwellman.jschallenge.java1.DecoderListener;
import com.danielwellman.jschallenge.java1.Encoder;
import com.danielwellman.jschallenge.java1.InputReader;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class ConverterApplicationTest {
    private final Mockery context = new Mockery();
    private final Encoder encoder = context.mock(Encoder.class);
    private final ConverterApplication converter = new ConverterApplication(encoder);

    private final InputReader inputFile = context.mock(InputReader.class);

    @Test
    public void readsTheFileAndAsksEncoderToEncodeItsContents() {
        final String fileContents = "contents";

        context.checking(new Expectations() {{
            allowing(inputFile).read();
            will(returnValue(fileContents));
            oneOf(encoder).encode(fileContents);
        }});

        converter.convert(inputFile);
    }

    @Test
    public void notifiesTheListenersWhenAFileIsDecoded() {
        final DecoderListener listener = context.mock(DecoderListener.class);
        final String message = "decoded message";

        context.checking(new Expectations() {{
            ignoring(inputFile);
            allowing(encoder).encode(with(any(String.class)));
            will(returnValue(message));

            oneOf(listener).messageDecoded(message);
        }});
        converter.addListener(listener);

        converter.convert(inputFile);
    }
}
