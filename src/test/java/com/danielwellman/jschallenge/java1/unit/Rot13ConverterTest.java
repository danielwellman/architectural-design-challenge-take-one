package com.danielwellman.jschallenge.java1.unit;

import com.danielwellman.jschallenge.java1.DecoderListener;
import com.danielwellman.jschallenge.java1.Encoder;
import com.danielwellman.jschallenge.java1.IoFacade;
import com.danielwellman.jschallenge.java1.Rot13Converter;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class Rot13ConverterTest {
    private final Mockery context = new Mockery();
    private final IoFacade ioFacade = context.mock(IoFacade.class);
    private final Encoder encoder = context.mock(Encoder.class);
    private final Rot13Converter converter = new Rot13Converter(ioFacade, encoder);

    @Test
    public void readsTheFileAndAsksEncoderToEncodeItsContents() {
        final String inputFilename = "inputFilename";
        final String fileContents = "contents";

        context.checking(new Expectations() {{
            allowing(ioFacade).readFile(inputFilename);
            will(returnValue(fileContents));

            oneOf(encoder).encode(fileContents);
        }});

        converter.convert(inputFilename);
    }

    @Test
    public void notifiesTheListenersWhenAFileIsDecoded() {
        final DecoderListener listener = context.mock(DecoderListener.class);
        final String message = "decoded message";

        context.checking(new Expectations() {{
            ignoring(ioFacade);
            allowing(encoder).encode(with(any(String.class)));
            will(returnValue(message));

            oneOf(listener).messageDecoded(message);
        }});
        converter.addListener(listener);

        converter.convert("irrelevant filename");
    }
}